package moneycalculator;

public class Number {
    private final long numerator;
    private final long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public Number(long numerator){
        this(numerator, 1);
    }
    
    public Number add(Number number){
        long numerator;
        long denominator;
        
        denominator=(this.denominator)*(number.denominator);
        numerator=((denominator/this.denominator)*this.numerator)+
                ((denominator/number.denominator)*number.numerator);
        
        return this(numerator,denominator);
    }
}
