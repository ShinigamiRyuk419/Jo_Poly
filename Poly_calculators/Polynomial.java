/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly_calculators;

/**
 *
 * @author Student.admin
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class Polynomial {

    private ArrayList<Term> terms = new ArrayList<Term>();


    public Polynomial() {
    }

    public void add(int coef, int exp) {

        ArrayList<Integer> used = new ArrayList<Integer>();

        if (coef != 0) {
            for (int i = 0; i < terms.size(); i++) {
            
                used.add(terms.get(i).getExp());
            }

            
            if (used.contains(exp)) {
                for (int i = 0; i < terms.size(); i++) {
                   
                    if (exp == terms.get(i).getExp()) {
                       
                        terms.set(i, new Term(terms.get(i).getCoef() + coef, exp));
                    }
                }
            } else {
                if (!(coef == 0 && exp == 0)) {
                    terms.add(new Term(coef, exp));
                }
            }
        }
    }

    public static Polynomial addition(Polynomial poly1, Polynomial poly2)
    {

        Polynomial polyResult = new Polynomial();
        ArrayList<Term> result = new ArrayList<Term>();

  
        if (poly1.terms.size() <= poly2.terms.size()) {
            result = sum(poly1.terms, poly2.terms);
        } else {
            result = sum(poly2.terms, poly1.terms);
        }

   
        polyResult.terms = (ArrayList<Term>) result.clone();
        return polyResult;
    }

  
    public static ArrayList<Term> sum(ArrayList<Term> a, ArrayList<Term> b) {
      
        ArrayList<Term> result = new ArrayList<Term>();

      
        ArrayList<Integer> used = new ArrayList<Integer>();

  
        for (int i = 0; i < a.size(); i++) {
            
            for (int j = 0; j < b.size(); j++) {
               
                if (((int) a.get(i).getExp()) == ((int) b.get(j).getExp())) {
                   
                    result.add(new Term(a.get(i).getCoef() + b.get(j).getCoef(), b.get(j).getExp()));
                    used.add(a.get(i).getExp());
                }
            }
        }
        for (int j = 0; j < a.size(); j++) {
    
            if (!(boolean) used.contains(a.get(j).getExp())) {		
                result.add(new Term(a.get(j).getCoef(), a.get(j).getExp()));
            }
        }


        for (int j = 0; j < b.size(); j++) {
            if (!(boolean) used.contains(b.get(j).getExp())) {
                result.add(new Term(b.get(j).getCoef(), b.get(j).getExp()));
            }
        }
        return result;
    }

    public static Polynomial subtraction(Polynomial poly1, Polynomial poly2)
    {
       
        Polynomial polyResult = new Polynomial();
        ArrayList<Term> result = new ArrayList<Term>();

        if (poly1.terms.size() <= poly2.terms.size()) {
            result = minus(poly1.terms, poly2.terms);
        } else {
            result = minus(poly2.terms, poly1.terms);
        }

    	
        polyResult.terms = (ArrayList<Term>) result.clone();
        return polyResult;
    }

    public static ArrayList<Term> minus(ArrayList<Term> a, ArrayList<Term> b) {
    
        ArrayList<Term> result = new ArrayList<Term>();

     
        ArrayList<Integer> used = new ArrayList<Integer>();

        
        for (int i = 0; i < a.size(); i++) {
        
            for (int j = 0; j < b.size(); j++) {
             
                if (((int) a.get(i).getExp()) == ((int) b.get(j).getExp())) {
             
                    result.add(new Term(a.get(i).getCoef() - b.get(j).getCoef(), b.get(j).getExp()));
                    used.add(a.get(i).getExp());
                }
            }
        }

   
        for (int j = 0; j < a.size(); j++) {

            if (!(boolean) used.contains(a.get(j).getExp())) {		
                result.add(new Term(a.get(j).getCoef(), a.get(j).getExp()));
            }
        }

        for (int j = 0; j < b.size(); j++) {
       
            if (!(boolean) used.contains(b.get(j).getExp())) {
      
                result.add(new Term(b.get(j).getCoef(), b.get(j).getExp()));
            }
        }

        return result;
    }

    public static Polynomial sort(Polynomial poly) {
     
        int[][] tmp = new int[poly.terms.size()][2];

        int[][] tmp2 = new int[poly.terms.size()][2];

     
        for (int i = 0; i < poly.terms.size(); i++) {
       
            tmp[i][0] = (int) (poly.terms.get(i).getCoef());


            tmp[i][1] = poly.terms.get(i).getExp();
        }

      
        Arrays.sort(tmp, Comparator.comparingInt(arr -> arr[1]));

   
        poly.terms.clear();

        //Counter
        int cont = tmp.length - 1;

        for (int i = 0; i < tmp2.length; i++) {
         
            tmp2[i][0] = tmp[cont][0];
            tmp2[i][1] = tmp[cont][1];

            cont--;
        }

        for (int i = 0; i < tmp2.length; i++) {
            poly.terms.add(new Term(tmp2[i][0], tmp2[i][1]));
        }

        return poly;
    }


    public static void printOut(String label, Polynomial polynomial) {

        String display = "";


        for (int i = 0; i < polynomial.terms.size(); i++) {
      
            int expo = polynomial.terms.get(i).getExp();
            int coef = (int) polynomial.terms.get(i).getCoef();

            if (coef > 1 || coef < -1) {
                display += Math.abs(coef);
            }

            if (expo == 1) {
                display += "x";    
            } else if (expo == 0) {
                display += "";
            } else {
                display += "x^";	
            }
            if (expo > 1 || expo < -1) {
                display += expo;    
            }
            if (i < polynomial.terms.size() - 1) 
            {
                if ((int) polynomial.terms.get(i + 1).getCoef() > 0) {
                    display += " + ";
                } else {
                    display += " - ";
                }
            }
        }
       
        System.out.println(label + display + "\n");
    }

    public int size() {
        int size = this.terms.size();

        return size;
    }
}
