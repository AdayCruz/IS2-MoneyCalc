package moneycalculator;

public class Number {
    private final long numerator;
    private final long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }
    
    public Number(long number){
        this(number, 1);
    }
    
    public Number (double number){
        this((long)number,1);
        simplify();
    }
    
    public void simplify(){
        int [] prime = getPrimes();
        
    }
    
    public Number add(Number number){
        long numerator;
        long denominator;
        
        denominator=(this.denominator) * (number.denominator);
        numerator=((denominator/this.denominator) * this.numerator) +
                ((denominator/number.denominator) * number.numerator);
        
        return this;
    }
    
    private long getPrimes(){
        return int [] prime = {1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 23};
    }
}
