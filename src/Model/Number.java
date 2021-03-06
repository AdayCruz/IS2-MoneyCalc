package Model;

import Components.PrimeCollection;

public class Number {
    private long numerator;
    private long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }
    
    public Number(long number){
        this(number, 1);
    }
    
    public Number (double number){
        numerator = (long) number;
        denominator = 1;
        int i=0;
        while (numerator != denominator * number && i <= 4){
            denominator = denominator * 10;
            i++;
            numerator = (long) (number * denominator);
        }
        simplify();
    }
    
    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }
    
    private void simplify(){
        PrimeCollection prime = new PrimeCollection();
        for (long value : prime) {
            while (isDivisible(value)){
                this.numerator = this.numerator/value;
                this.denominator = this.denominator/value;
            }
            //if ((value>this.numerator/2)&&(value>this.denominator/2))break;
            if (value>10000)break;
        }
    }
    
    public Number add(Number number){
        long numerator;
        long denominator;
        
        denominator=this.denominator * number.denominator;
        numerator=((denominator/this.denominator) * this.numerator) +
                ((denominator/number.denominator) * number.numerator);
        
        return new Number(numerator,denominator);
    }
    
    public Number substract(Number number){
        long numerator;
        long denominator;
        
        denominator=this.denominator * number.denominator;
        numerator=((denominator/this.denominator) * this.numerator) -
                ((denominator/number.denominator) * number.numerator);
        
        return new Number(numerator,denominator);
    }
    
    public Number multiply(Number number){
        long numerator;
        long denominator;
        
        denominator=this.denominator * number.denominator;
        numerator=this.numerator * number.numerator;
        
        return new Number(numerator,denominator);
    }
    
    public Number divide(Number number){
        long numerator;
        long denominator;
        
        denominator=this.denominator * number.numerator;
        numerator=this.numerator * number.denominator;
        
        return new Number(numerator,denominator);
    }

    private boolean isDivisible(long prime) {
        return ( ( numerator % prime ) == 0 ) && ( ( denominator % prime ) == 0 );
    }
    
    @Override
    public String toString(){
        return Double.toString((double)numerator/(double)denominator);
    }
}
