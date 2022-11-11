/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package_3;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Student.admin
 */
public class Polynomial {
    public int coefficient;
    public int degree;
    
    public static Set<Integer> coef = new HashSet<Integer>();
    public static Set<Integer> deg = new HashSet<Integer>();
    
//    public static void createTerm(int coefficient , int degree){
//        coef.add(coefficient);
//        deg.add(degree);
        
        // Converting HashSet to Array
//        String[] arrayCoef = coef.toArray(new String[coef.size()]);
    
    public Integer[] convertD = coef.toArray(new Integer[coef.size()]);// Converting HashSet to Array


    public static Set<Integer> getCoef() {
        return coef;
    }

    public static void setCoef(Set<Integer> coef) {
        Polynomial.coef = coef;
    }

    public static Set<Integer> getDeg() {
        return deg;
    }

    public static void setDeg(Set<Integer> deg) {
        Polynomial.deg = deg;
    }
        

        
//    }
    public void addCoef(){
        Polynomial p = new Polynomial();
       Integer[] convertC = coef.toArray(new Integer[coef.size()]);// Converting HashSet to Array


        for (int i = coefficient; i < coef.size(); i++) {
            coef.add(coefficient);
        }
        System.out.println("----------Coefficient--------------");
        System.out.println(coef);  
        System.out.println("Element at index 1 is: "
                           + convertC[1]);
    }
    
    public void addDeg(){
        Polynomial p = new Polynomial(); 
        for (int i = 0; i < deg.size(); i++) {
            deg.add(degree);
        }
        System.out.println("----------Degree--------------");
        System.out.println(deg);  
    }
    
   
    
    
}
