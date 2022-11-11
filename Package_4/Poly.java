/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package_4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Student.admin
 */
public class Poly {
    
    
    public static Set<Integer> coef = new HashSet<Integer>();  // coefficients
    public int deg;     // degree of polynomial (0 for the zero polynomial)
//    private Integer[] convertC;
    
    Integer[] convertC = coef.toArray(new Integer[coef.size()]);


    // a * x^b
    public Poly( int a, int b ){// a being the coefficient and b as degree
//        Poly p = new Poly(4,2);
//        var convertC = coef.toArray(new Integer[coef.size()]);
        convertC = new Integer[ b + 1 ];
        convertC[ b ] = a;
        deg = degree();
    }
//convertC[i]

    public Poly( Poly p ){
//        var convertC = coef.toArray(new Integer[coef.size()]);
        convertC = new Integer[ p.convertC.length];
        for( int i = 0; i < p.convertC.length; i++ ){
            convertC[ i ] = p.convertC[ i ];
        }//end for
        deg = p.degree();
    }


    // return the degree of this polynomial (0 for the zero polynomial)
    public int degree(){
        int d = 0; //d being the degree
        for( int i = 0; i < convertC.length; i++ )
            if( convertC[ i ] != 0 ) d = i;
        return d;
    }


    // return c = a + b
    public Poly plus( Poly b ){
        Poly a = this;
        Poly c = new Poly( 0, Math.max( a.deg, b.deg ) );
        for( int i = 0; i <= a.deg; i++ ) c.convertC[ i ] += a.convertC[ i ];
        for( int i = 0; i <= b.deg; i++ ) c.convertC[ i ] += b.convertC[ i ];
        c.deg = c.degree();
        return c;
    }


    // return (a - b)
    public Poly minus( Poly b ){
        Poly a = this;
        Poly c = new Poly( 0, Math.max( a.deg, b.deg ) );
        for( int i = 0; i <= a.deg; i++ ) c.convertC[ i ] += a.convertC[ i ];
        for( int i = 0; i <= b.deg; i++ ) c.convertC[ i ] -= b.convertC[ i ];
        c.deg = c.degree();
        return c;
    }





    // get the coefficient for the highest degree
    public int coeff(){return coeff( degree() ); }


    // get the coefficient for degree d
    public int coeff( int degree ){
        if( degree > this.degree() ) throw new RuntimeException( "bad degree" );
        return convertC[ degree ];
    }



    // do a and b represent the same polynomial?
    public boolean eq( Poly b ){
        Poly a = this;
        if( a.deg != b.deg ) return false;
        for( int i = a.deg; i >= 0; i-- )
            if( a.convertC[ i ] != b.convertC[ i ] ) return false;
        return true;
    }


    // test wether or not this polynomial is zero
    public boolean isZero(){
        for( int i : coef ){
            if( i != 0 ) return false;
        }//end for
        return true;
    }




    // convert to string for display
    public String toString(){
        if( deg == 0 ) return "" + convertC[ 0 ];
        if( deg == 1 ) return convertC[ 1 ] + "x + " + convertC[ 0 ];
        String s = convertC[ deg ] + "x^" + deg;
        for( int i = deg - 1; i >= 0; i-- ){
            if( convertC[ i ] == 0 ){
                continue;
            }else if( convertC[ i ] > 0 ){
                s = s + " + " + ( convertC[ i ] );
            }else if( convertC[ i ] < 0 ) s = s + " - " + ( -convertC[ i ] );
            if( i == 1 ){
                s = s + "x";
            }else if( i > 1 ) s = s + "x^" + i;
        }
        return s;
    }


    public static void main( String[] args ){
//        Polynomial zero = new Polynomial( 0, 0 );
        
        //creating the terms
        Poly p1 = new Poly( 1, 3 );// (coeffiecient, degree)
        Poly p2 = new Poly( 2, 2 );
        Poly p3 = new Poly( 4, 0 );
        Poly p4 = new Poly( 0, 1 );
        // creating the polynomial
        Poly p = p1.plus( p2 ).plus( p3 ).plus( p4 );   // 4x^3 + 3x^2 + 1

        Poly q1 = new Poly( 5, 3 );
        Poly q2 = new Poly( 3, 0 );
        // creating the polynomial
        Poly q = q1.plus( q2 );                     // 3x^2 + 5
        
        Poly subtract = p.minus(q);

        Poly result = p.plus( q );


        System.out.println( "First Polynomial:        " + p );
        System.out.println( "Second Polynomial:       " + q );
        System.out.println();

        System.out.println( "Adding the two polynomials ");
        System.out.println( "---------------------------------" );
        System.out.println( "Answer:" );
        System.out.println(  result );
        System.out.println( "---------------------------------" );
        System.out.println(  );
        
        System.out.println( "=================================" );

        System.out.println(  );
        System.out.println( "Subtracting the two polynomials ");
        System.out.println( "---------------------------------" );
        System.out.println( "Answer:" );
        System.out.println(  subtract );
        System.out.println( "---------------------------------" );


        System.out.println();
        
    }

}

