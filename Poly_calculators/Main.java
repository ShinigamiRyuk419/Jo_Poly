/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly_calculators;

/**
 *
 * @author Student.admin
 */
public class Main {

	public static void main(String[] args) 
	{
		Polynomial poly1 = new Polynomial();
		Polynomial poly2 = new Polynomial();
		Polynomial result1 = new Polynomial();
                Polynomial result2 = new Polynomial();

		
		// Add few terms to the first polynomial 

                //(coefficient, exonent)
                
		poly1.add(1,5);		
		poly1.add(-2,2);	
		poly1.add(1,4);		
		poly1.add(5,0);		
		
//                poly1.add(0,0); //to test if no polynomial defined
		
			
		//Reduced to: 2x^3 - x^2 + 3 + 4x^4
		poly2.add(2,3);		
		poly2.add(-1,2);	
		poly2.add(5,0);		
		poly2.add(4,4);     	
		poly2.add(-2,0);    	
		poly2.add(0,0);     	//Discarded
		poly2.add(0,3);     	//Discarded
		
		//to store the result of the addition function
		result1 = Polynomial.addition(poly1, poly2);
                result2 = Polynomial.subtraction(poly1, poly2);
                
                //to store the result of the subtraction function
                
                System.out.println("---------------------------------------------------------");
		System.out.println("                Polynomial Calculator");
                System.out.println("-------------------------------------------------------\n");


		
		if(poly1.size() > 0)
                    Polynomial.printOut("1st Polynomial:\t\t\t\t", poly1);
                else 
                    System.out.println("No polynomial defined\n");
                
                
		if(poly2.size() > 0)
                    Polynomial.printOut("2nd Polynomial:\t\t\t\t", poly2);
                else 
                    System.out.println("No polynomial defined\n");
		
		if(poly1.size() > 1)
                    Polynomial.printOut("1st Polynomial in descending order:\t", Polynomial.sort(poly1));
                
		if(poly2.size() > 1)
                    Polynomial.printOut("2nd Polynomial in descending order:\t", Polynomial.sort(poly2));
		
		if(!(poly1.size() == 0 || poly2.size() == 0))
                    Polynomial.printOut("Addition result:\n\n\t", Polynomial.sort(result1));
                else 
                    System.out.println("No addition operation performed\n");
                
                if(!(poly1.size() == 0 || poly2.size() == 0))
                    Polynomial.printOut("Subtraction result:\n\n\t", Polynomial.sort(result2));
                else 
                    System.out.println("No addition operation performed\n");

	}
}

