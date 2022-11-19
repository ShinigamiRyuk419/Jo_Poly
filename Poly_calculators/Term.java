/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly_calculators;

/**
 *
 * @author Student.admin
 */
public class Term {

	private double coef; //Store the term coefficient
	private int exp;  //Store the term exponent	
	public Term(double c, int e){coef = c; exp = e;} //Constructor
	public void add(double c, int e){coef = c; exp = e;} //add a term to the collection
	public double getCoef(){return coef;} //getter methods
	public int getExp(){return exp;}	
	
}

