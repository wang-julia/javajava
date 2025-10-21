//Julia Wang
//Fraction Assignment
public class Fraction {

    //implements FractionInterface

    //private instance variables
    private int mydenom;
    private int mynum;

    //constructors
    public Fraction()
    {
        mynum = 0;
        mydenom = 1;
    }

    public Fraction(int n, int d)
    {
        mynum = n;
        mydenom = d;
        simplify();
    }

    public Fraction(double decimal)
    {
        //while the the num is a decimal, the loop multiplies the num and denom by 10 until the num is an integer
        mydenom = 1; 
        while (decimal%1.0 >= 0.000000001 || decimal%1.0 <= -0.000000001) //wyatt helped!--he said to set the bounds to a very small number instead of 0 to account for floating point numbers(?)
        {
            decimal *= 10;
            mydenom *= 10; 
        }
        mynum = (int)(decimal);
        simplify();
    }

    //Private Method
    //SIMPLIFY METHOD!!!
    private void simplify()
    {
        //if the denominator is zero then the fraction becomes 0/1
        if (mydenom == 0)
        {
            System.out.println("ERROR: The fraction does not exist. Your fraction will convert to 0/1."); 
            mynum = 0; 
            mydenom = 1; 
        }

        //if the numerator is zero then the fraction becomes 0/1
        if (mynum == 0)
        {
            mynum = 0; 
            mydenom = 1; 
        }

        //if the denominator is negative then it moves the neg sign to the numerator
        //if both the numerator and denominator are negative then it turns the fraction positive
        if (mydenom < 0)
        {
            mynum = -mynum;
            mydenom = -mydenom;
        }

        //GCD PART!
        //Find if there is a GCD between the numerator and the denominator. If the GCD is greater than 1 the fraction can be simplified. 
        int divisor; 
        int gcd = 1;

        //Have to use the absolute value of the numerator and denominator in order for the for loop to work.
        int absnum = mynum; //cannot be initialized to an integer because if the number is not negative then it will mess up the for loop below. 
        int absdenom = mydenom; //same here ^

        //turns neg numbers pos
        if (mynum < 0){
            absnum = -mynum;
        }

        if (mydenom < 0){
            absdenom = -mydenom;
        } 

        //the loops checks if both numbers (num & denom) are divisible by all integers up until the divisor reaches the value of one of the numbers
        //the gcd is set to the greatest common multiple
        for (divisor = 1; divisor <= absnum && divisor <= absdenom; divisor++)
        {
            if (absnum%divisor == 0 && absdenom%divisor == 0)
            {
                gcd = divisor; 
            }
        }    
        //System.out.println("Testing! The gcd of " + mynum + "/" + mydenom + " is " + gcd);

        //divides the num and denom by the gcd if the gcd is not 1
        if (gcd > 1)
        {
            mynum = mynum/gcd; 
            mydenom = mydenom/gcd;
        }
    }

    //Public Methods
    //adds two fractions
    public Fraction add(Fraction f)
    {
        Fraction sum = new Fraction();
        sum.mydenom = this.mydenom*f.mydenom;
        sum.mynum = this.mynum*f.mydenom + f.mynum*this.mydenom;

        sum.simplify();
        return sum;
    }

    //subtracts two fractions
    public Fraction subtract(Fraction f)
    {
        Fraction difference = new Fraction();
        difference.mydenom = this.mydenom*f.mydenom;
        difference.mynum = this.mynum*f.mydenom - f.mynum*this.mydenom;

        difference.simplify();
        return difference;
    }

    //multiplies two fractions
    public Fraction multiply(Fraction f)
    {
        Fraction product = new Fraction();
        product.mydenom = this.mydenom*f.mydenom;
        product.mynum = this.mynum*f.mynum;

        product.simplify();
        return product;
    }

    //divides two fractions
    public Fraction divide(Fraction f)
    {
        //dividing fractions = multiply the first fraction by the recipricol of the other
        Fraction dividend = new Fraction();
        dividend.mydenom = this.mydenom*f.mynum;
        dividend.mynum = this.mynum*f.mydenom;

        dividend.simplify();
        return dividend;
    }

    //converts a fraction to a double
    public double toDouble()
    {
        double decimal = ((double)mynum)/mydenom;
        return decimal;
    }

    //compares two fractions
    public int compareTo(Fraction f)
    {
        //cross multiply: a/b > c/d if and only if a*d > b*c
        //a/b = this and c/d = f
        int ad = this.mynum*f.mydenom;
        int bc = this.mydenom*f.mynum;

        if (ad > bc)
            return 1;
        else if (ad < bc)
            return -1;
        else
            return 0;
    }

    //tests if two fractions are equal
    public boolean equals(Fraction f)
    {
        if (this.mynum == f.mynum && this.mydenom == f.mydenom)
            return true;
        else
            return false;
    }

    //tests if a fraction is equal to an entered decimal
    public boolean equals(double dd)
    {
        //converts "this" fraction to a decimal
        double thisfractodec = (double)this.mynum/this.mydenom;

        double range = 0.00000001; //two doubles within this range of error are considered to be equal

        //checks to see if the two values are close enough to each other
        if ((thisfractodec - dd < range) && (thisfractodec - dd > -range))
            return true;
        else
            return false;
    }

    //tests if a fraction is equal to an entered fraction?????
    public boolean equals(int n, int d)
    {
        Fraction intsfrac = new Fraction(n, d);

        if (this.mynum == intsfrac.mynum && this.mydenom == intsfrac.mydenom)
            return true;
        else
            return false;
    }


    //Accessors
    public int getNumerator()
    {
        return mynum;
    }

    public int getDenominator()
    {
        return mydenom;
    }

    //calls/prints toString method
    public void print()
    {
        System.out.println(toString());
        //System.out.println(mynum + "/" + mydenom);
    }

    //puts a / between the numerator and denominator when printing
    public String toString()
    {
        String s1;
        s1 = mynum + "/" + mydenom;
        return s1;
    }

}
