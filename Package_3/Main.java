/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package_3;

import static Package_3.Polynomial.coef;
import static Package_3.Polynomial.deg;

/**
 *
 * @author Student.admin
 */
public class Main {
    public static void main(String[] args){
        Polynomial p = new Polynomial();

        coef.add(5);
        coef.add(3);
        coef.add(4);

        deg.add(1);
//        System.out.println("coefficient" +  coef);
//        System.out.println("Expoenent" +  deg);

        p.addCoef();
        p.addDeg();
    }
}
