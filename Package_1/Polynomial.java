/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package_1;

/**
 *
 * @author Student.admin
 */
public class Polynomial {
    
    
    private int[] coef;  // coefficients
    private int deg;     // degree of polynomial (0 for the zero polynomial)


    // a * x^b
    public Polynomial( int a, int b ){// a being the coefficient and b as degree
        coef = new int[ b + 1 ];
        coef[ b ] = a;
        deg = degree();
    }


    public Polynomial( Polynomial p ){
        coef = new int[ p.coef.length ];
        for( int i = 0; i < p.coef.length; i++ ){
            coef[ i ] = p.coef[ i ];
        }//end for
        deg = p.degree();
    }


    // return the degree of this polynomial (0 for the zero polynomial)
    public int degree(){
        int d = 0; //d being the degree
        for( int i = 0; i < coef.length; i++ )
            if( coef[ i ] != 0 ) d = i;
        return d;
    }


    // return c = a + b
    public Polynomial plus( Polynomial b ){
        Polynomial a = this;
        Polynomial c = new Polynomial( 0, Math.max( a.deg, b.deg ) );
        for( int i = 0; i <= a.deg; i++ ) c.coef[ i ] += a.coef[ i ];
        for( int i = 0; i <= b.deg; i++ ) c.coef[ i ] += b.coef[ i ];
        c.deg = c.degree();
        return c;
    }


    // return (a - b)
    public Polynomial minus( Polynomial b ){
        Polynomial a = this;
        Polynomial c = new Polynomial( 0, Math.max( a.deg, b.deg ) );
        for( int i = 0; i <= a.deg; i++ ) c.coef[ i ] += a.coef[ i ];
        for( int i = 0; i <= b.deg; i++ ) c.coef[ i ] -= b.coef[ i ];
        c.deg = c.degree();
        return c;
    }





    // get the coefficient for the highest degree
    public int coeff(){return coeff( degree() ); }


    // get the coefficient for degree d
    public int coeff( int degree ){
        if( degree > this.degree() ) throw new RuntimeException( "bad degree" );
        return coef[ degree ];
    }



    // do a and b represent the same polynomial?
    public boolean eq( Polynomial b ){
        Polynomial a = this;
        if( a.deg != b.deg ) return false;
        for( int i = a.deg; i >= 0; i-- )
            if( a.coef[ i ] != b.coef[ i ] ) return false;
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
        if( deg == 0 ) return "" + coef[ 0 ];
        if( deg == 1 ) return coef[ 1 ] + "x + " + coef[ 0 ];
        String s = coef[ deg ] + "x^" + deg;
        for( int i = deg - 1; i >= 0; i-- ){
            if( coef[ i ] == 0 ){
                continue;
            }else if( coef[ i ] > 0 ){
                s = s + " + " + ( coef[ i ] );
            }else if( coef[ i ] < 0 ) s = s + " - " + ( -coef[ i ] );
            if( i == 1 ){
                s = s + "x";
            }else if( i > 1 ) s = s + "x^" + i;
        }
        return s;
    }


    public static void main( String[] args ){
//        Polynomial zero = new Polynomial( 0, 0 );
        
        //creating the terms
        Polynomial p1 = new Polynomial( 1, 3 );// (coeffiecient, degree)
        Polynomial p2 = new Polynomial( 2, 2 );
        Polynomial p3 = new Polynomial( 4, 0 );
        Polynomial p4 = new Polynomial( 0, 1 );
        // creating the polynomial
        Polynomial p = p1.plus( p2 ).plus( p3 ).plus( p4 );   // 4x^3 + 3x^2 + 1

        Polynomial q1 = new Polynomial( 5, 3 );
        Polynomial q2 = new Polynomial( 3, 0 );
        // creating the polynomial
        Polynomial q = q1.plus( q2 );                     // 3x^2 + 5
        
        Polynomial subtract = p.minus(q);

        Polynomial result = p.plus( q );


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

