/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly_calculators;

import java.io.*;

/**
 *
 * @author Student.admin
 */
public class Polynomial extends UnorderedArrayList {

        //Default constructor
        //Postcondition: An array of the size 100, and
        //             length and maxSize are set to 100
    public Polynomial()
    {
         super();
         length = 100;
    }

        //Constructor with parameter
        //Postcondition: An array of the size specified by
        //      the parameter size is created, length and maxSize
        //      are initialized to size
    public Polynomial(int size)
    {
         super(size);
         length = size;
    }

        //copy constructor
    public Polynomial(Polynomial right)
    {
         super(right);
    }


        //Method to copy the coefficients of the polynomial
        //specified by the parameter right
        //Postcondition: The coefficients of the polynomial
        //               specified by right are copied.
    public void copy(Polynomial right)
    {
        super.copyList(right);
    }

        //Method to evaluate a polynomial at a given value
        //Postcondition: The polynomial is evaluated at x and
        //               the value is returned
    public double evaluate(double x)
    {
        double value = 0.0;

        DoubleElement coeff = new DoubleElement();

        for(int i = 0; i < length; i++)
        {
            coeff.makeCopy((DoubleElement) list[i]);

            if(coeff.getNum() != 0.0)
               value = value + coeff.getNum() * Math.pow(x,i);
        }

        return value;
    }


        //Method to add two polynomials
        //Postcondition: This polynomial is added with the polynomial
        //          specified by the parameter right. A reference of
        //          the result is returned.
    public Polynomial add(Polynomial right)
    {
        int size = max(length, right.length);
        int i;
        double sumCoeff;

        DoubleElement coeffP = new DoubleElement();
        DoubleElement coeffQ = new DoubleElement();

        DoubleElement z;

        Polynomial temp = new Polynomial(size);

        for(i = 0; i < min(length, right.length); i++)
        {
            coeffP.makeCopy((DoubleElement) list[i]);
            coeffQ.makeCopy((DoubleElement) right.list[i]);

            sumCoeff = coeffP.getNum() + coeffQ.getNum();
            z = new DoubleElement(sumCoeff);
            temp.list[i] = z;
        }

        if(size == length)
             for(i = min(length, right.length); i < length; i++)
                 temp.list[i] = list[i].getCopy();
        else
           for(i = min(length, right.length); i < right.length; i++)
               temp.list[i] = right.list[i].getCopy();

        return temp;
    }

        //Method to subtract two polynomials
        //Postcondition: The polynomial specified by the
        //          parameter right is subtracted from this
        //          polynomial. A reference of the result is returned.
    public Polynomial subtract(Polynomial right)
    {
        int size = max(length, right.length);
        int i;
        double diffCoeff;
        double coeff;

        DoubleElement coeffP = new DoubleElement();
        DoubleElement coeffQ = new DoubleElement();

        DoubleElement z;

        Polynomial temp = new Polynomial(size);

        for(i = 0; i < min(length, right.length); i++)
        {
            coeffP.makeCopy((DoubleElement) list[i]);
            coeffQ.makeCopy((DoubleElement) right.list[i]);

            diffCoeff = coeffP.getNum() - coeffQ.getNum();
            z = new DoubleElement(diffCoeff);
            temp.list[i] = z;
        }

        if(size == length)
           for(i = min(length, right.length); i < length; i++)
               temp.list[i] = list[i].getCopy();
        else
           for(i = min(length, right.length); i < right.length; i++)
           {
               z = new DoubleElement();
               z.makeCopy((DoubleElement) right.list[i]);
               coeff = z.getNum();
               z.setNum(-coeff);
               temp.list[i] = z;
           }

        return temp;
    }

        //Method to multiply two polynomials
        //Postcondition: This polynomial is multiplied with the
        //          polynomial specified by the parameter right. A
        //          reference of the result is returned.
    public Polynomial multiply(Polynomial right)
    {

        Polynomial temp = new Polynomial();

        System.out.println("See Programming Exercise 5 at the end of the chapter.");

        return temp;
    }

        //Method to read the coefficients of a polynomial
    public void read() throws IOException
    {
        BufferedReader keyboard = new
            BufferedReader(new InputStreamReader(System.in));

        DoubleElement x = new DoubleElement();

        System.out.println("The degree of this polynomial is: "
                         + (length - 1));
        for(int i = 0; i < length; i++)
        {
            System.out.print("Enter the coefficient of x^"
                             + i + ": ");
            System.out.flush();

            x.setNum(Double.parseDouble(keyboard.readLine()));

            list[i] = x.getCopy();
        }
    }

          //Method to return the string containing the polynomial
    public String toString()
    {
        int i;
        int firstNonzeroCoeff = 0;
        DoubleElement x = new DoubleElement();
        String str = "";

        for(i = 0; i < length; i++)
        {
            x.makeCopy((DoubleElement) list[i]);

            if(x.getNum() != 0.0)
            {
               firstNonzeroCoeff = i;
               break;
            }
        }

        if(firstNonzeroCoeff < length)
        {
           if(firstNonzeroCoeff == 0)
              str = list[firstNonzeroCoeff] + " ";
           else
              str = list[firstNonzeroCoeff] + "x^"
                       + firstNonzeroCoeff + " ";

           for(i = firstNonzeroCoeff + 1; i < length; i++)
           {
               x.makeCopy((DoubleElement) list[i]);

               if(x.getNum() != 0.0)
                  if(x.getNum() > 0.0)
                     str += "+ " + x.getNum() + "x^" + i + " ";
                  else
                     str += "- " + -x.getNum() + "x^" + i + " ";
           }
        }

        return str;
    }

        //Method to determine the smaller of x and y
        //Postcondition: The smaller of x and y is returned
    public int min(int x, int y)
    {
        if(x <= y)
           return x;
        else
           return y;
    }

        //Method to determine the larger of x and y
        //Postcondition: The larger of x and y is returned
    public int max(int x, int y)
    {
        if(x >= y)
           return x;
        else
           return y;
    }
}

