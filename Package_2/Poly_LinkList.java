/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package_2;

/**
 *
 * @author Student.admin
 */
public class Poly_LinkList {
    
    public static Node addPolynomial(Node p1, Node p2)
    {
        Node a = p1, b = p2, newHead = new Node(0, 0), c = newHead;
  
        while (a != null || b != null) 
        {
            if (a == null) 
            {
                c.next = b;
                break;
            }
            else if (b == null) 
            {
                c.next = a;
                break;
            }
  
            else if (a.power == b.power) 
            {
                c.next = new Node(a.coeff + b.coeff, a.power);
                a = a.next;
                b = b.next;
            }
  
            else if (a.power > b.power) 
            {
                c.next = new Node(a.coeff, a.power);
                a = a.next;
            }
  
            else if (a.power < b.power) 
            {
                c.next = new Node(b.coeff, b.power);
                b = b.next;
            }
            c = c.next;
        }
        return newHead.next;
    }
}
  
// Utilities for Linked List 
// Nodes
class Node 
{
    int coeff;
    int power;
    Node next;
    Node(int a, int b)
    {
        coeff = a;
        power = b;
        next = null;
    }
}
  
// Linked List main class
class LinkedList 
{  
    public static void main(String args[])
    {
        Node start1 = null, cur1 = null,  start2 = null, cur2 = null;
        int[] list1_coeff = {5, 4, 2};
        int[] list1_pow = {2, 1, 0};
        int n = list1_coeff.length;
  
        int i = 0;
        while (n-- > 0) 
        {
            int a = list1_coeff[i];
            int b = list1_pow[i];
            Node ptr = new Node(a, b);
            if (start1 == null) 
            {
                start1 = ptr;
                cur1 = ptr;
            }
            else 
            {
                cur1.next = ptr;
                cur1 = ptr;
            }
            i++;
        }
  
        int[] list2_coeff = {-5, -5};
        int[] list2_pow = {1, 0};
        n = list2_coeff.length;
  
        i = 0;
        while (n-- > 0) 
        {
            int a = list2_coeff[i];
            int b = list2_pow[i];
  
            Node ptr = new Node(a, b);
  
            if (start2 == null) 
            {
                start2 = ptr;
                cur2 = ptr;
            }
            else 
            {
                cur2.next = ptr;
                cur2 = ptr;
            }
            i++;
        }
  
        Poly_LinkList obj = new Poly_LinkList();
        
        Node sum = obj.addPolynomial(start1, start2);
        Node result = sum;
        while (result != null) 
        {
            System.out.print(result.coeff + "x^" + result.power);
            if (result.next != null)
                System.out.print(" + ");
            result = result.next;
        }
        System.out.println();
    }
}
