/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly_calculators;

/**
 *
 * @author Student.admin
 */
public class DoubleElement extends DataElement {

    protected double num;

    public DoubleElement()
    {
        num = 0.0;
    }

    public DoubleElement(double x)
    {
        num = x;
    }

    public DoubleElement(DoubleElement other)
    {
        num = other.num;
    }
    
    
    public boolean equals(DataElement otherElement)
    {
        DoubleElement temp = (DoubleElement) otherElement;

        return (num == temp.num);
    }

    public int compareTo(DataElement otherElement)
    {
        DoubleElement temp = (DoubleElement) otherElement;

        if(num < temp.num)
          return -1;
        else
           if(num > temp.num)
              return 1;
           else
              return 0;
    }
    
   	public void setNum(double x)
    {
        num = x;
    }

    public double getNum()
    {
        return num;
    }

    public void makeCopy(DataElement otherElement)
    {
          DoubleElement temp = (DoubleElement) otherElement;

          num = temp.num;
    }

    public DataElement getCopy()
    {
        DoubleElement temp = new DoubleElement(num);
        return temp;
    }

    public String toString()
    {
        return String.valueOf(num);
    }
}

