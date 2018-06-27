/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.util.ArrayList;

/**
 *
 * @author Nader
 */
public class distance {
    private ArrayList<point> p;
    private ArrayList<cluster> c ;
     public distance()
     {
         p= new ArrayList<point>();
         c= new ArrayList<cluster>();
     }
     public ArrayList<cluster> getCluster()
     {
         return c;
     }
      public ArrayList<point> getpoint()
     {
         return p;
     }
     public void ajoutcluster(cluster k)
     {
         c.add(k);
     }
     public void ajoutpoint(point p)
     {
         this.p.add(p);     
     }
     public void clearcluster()
     {
         c.clear();
     }
     
    public double distancepoint(point p1,point p2)
    {double b=0;
        for (int i = 0; i < p1.getPoint().size(); i++) {
            b+=Math.pow(p1.getPoint().get(i)-p2.getPoint().get(i), 2);     
            
        }
        double c=Math.sqrt(b);
        return c;
     
    }
    public void compare()
    {
        for (int i = 0; i < c.size(); i++) {
            c.get(i).clear();
        }
        //System.out.println(p.size());
        for (int i = 0; i < p.size(); i++) {
            double x=distancepoint(c.get(0).getCentre(), p.get(i));
            for (int j = 1; j <c.size(); j++) {
                double f=distancepoint(c.get(j).getCentre(), p.get(i));
                if (f<x)
                {
                    x=f;
                }
                
            }
            //System.out.println(x);
            boolean test=false;
            int k=0;
            while(!test)
            {
                double s=distancepoint(c.get(k).getCentre(), p.get(i));
                //System.out.println(s);
                if (s==x)
                {
                    test=true;
                    c.get(k).ajout(p.get(i));
                }
                else
                {
                    k++;
                }
            }
            //System.out.println("13");
        }
        //System.out.println("18");
    }
    public boolean comparecentrecluster()
    {
        int i=0;
        boolean test=false;
        while(!test && i<c.size())
        {
            if(c.get(i).compareCentre()==false)
            {
                test=true;
            }
            else
            {
                i++;
            }
        }
        if (test==false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
