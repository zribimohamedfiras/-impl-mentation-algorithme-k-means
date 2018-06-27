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
public class cluster {
    public ArrayList<point>  centres ;
     private point centre;
     private ArrayList<point> clusters; 
     
      public cluster(){
    clusters= new ArrayList<point>(); 
    centres=new ArrayList<point>();
    
    }
      public void setCentre(point centre)
      {
          this.centre=centre;
          centres.add(centre);
      }
      public void ajout(point p)
      {
          clusters.add(p);
      }
      public void clear()
      {
          clusters.clear();
      }
      public point getCentre()
      {
          return centre;
      }
      public ArrayList<point> getClusters()
      {
          return clusters;
      }
      
      public void calculeCentre()
      {int x=clusters.get(0).getPoint().size();     
      
      centre.clear();  
              
      double c;
          for (int i=0; i<x; i++){
          c=0;         
          for (int j=0 ;j<clusters.size();j++){             
          c+= clusters.get(j).getPoint().get(i);
          //System.out.println(c);
          }
          //System.out.println(c);
         double s=c/(clusters.size());
         //System.out.println(s);
         centre.ajout(s);
         centres.add(centre);
          }
      }
 public String affichage() {
  String s = "le centre de cluster est : " + centre.affichagPoint();
    
     
 String c=" ; les points de ce cluster sont :  ";    
 for (int i = 0; i < clusters.size(); i++) {
       
         c+= clusters.get(i).affichagPoint();
     }
     
return s+c;
}     
 public void ajoutcentre(point p)
 {
     centres.add(p);
 }
 public boolean compareCentre(){
 
      if(centres.size()>1)
      {
          if( centres.get(centres.size()-1)== centres.get(centres.size()-2))
          {
              return true;
              }
          else
          {
          return false;
          }
     }
      else
      {
          return false;
      }
 }
 
}
