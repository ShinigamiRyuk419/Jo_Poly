/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Poly_calculators;

import java.io.IOException;

/**
 *
 * @author Student.admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       Polynomial p = new Polynomial(4);             //Line 1
       Polynomial q = new Polynomial(8);             //Line 2

       p.read();                                     //Line 3
       System.out.println();                         //Line 4
       System.out.println("Line 5: p(x): " + p);     //Line 5

       System.out.println("Line 6: p.evaluate(2): "
                         + p.evaluate(2));           //Line 6
       System.out.println();                         //Line 7

       q.read();                                     //Line 8
       System.out.println("Line 9: q(x): " + q);     //Line 9

       System.out.println("Line 10: p(x) + q(x): "
                         + p.add(q));                //Line 10

       System.out.println("Line 11: p(x) - q(x): "
                         + p.subtract(q));           //Line 11
    }
    
}
