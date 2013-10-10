package moneycalculator;

public class Number {
    private long numerator;     //Need to add final long?
    private long denominator;   //Need to add final long?

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
        while (numerator != denominator * number){
            denominator = denominator * 10;
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
    
    public void simplify(){
        long [] prime = getPrimes();
        for (long value : prime) {
            while (isDivisible(value)){
                this.numerator = this.numerator/value;
                this.denominator = this.denominator/value;
            }
        }
    }
    
    public Number add(Number number){
        long numerator;
        long denominator;
        
        denominator=(this.denominator) * (number.denominator);
        numerator=((denominator/this.denominator) * this.numerator) +
                ((denominator/number.denominator) * number.numerator);
        
        return this;
    }
    
    private long[] getPrimes(){
        long [] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        return primeNumbers;
    }

    private boolean isDivisible(long prime) {
        return ( ( numerator % prime ) == 0 ) && ( ( denominator % prime ) == 0 );
    }
}
