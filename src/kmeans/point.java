/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;
/**
 *
 * @author Nader
 */
import java.util.ArrayList;
public class point {
    private String nom;
    private ArrayList<Double> t; 
    public  point(String nom){
    t= new ArrayList<Double>(); 
    this.nom=nom;
    }
    
    public void ajout(double P){
    t.add(P);
    }
    public point copy()
    {
        point x=new point("centre");
        for (int i = 0; i < this.getPoint().size(); i++) {
           x.getPoint().add(this.getPoint().get(i)); 
        }
        return x;
    }
    
    public ArrayList<Double> getPoint(){
       return t;
       
       }
    public void clear()
    {
        t.clear();
    }
    
    public String affichagPoint(){
    
     String s = nom+"  (";
     for (int i = 0; i < t.size(); i++) {
         s+= t.get(i)+",";
     }
     s+=")  ";
     return s; 
    }
    
}
