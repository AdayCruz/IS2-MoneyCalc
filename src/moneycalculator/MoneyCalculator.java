package moneycalculator;

public class MoneyCalculator {

    public static void main(String[] args) {
        Number myNumber = new Number(33.3);
        Number myOtherNumber = myNumber.divide(new Number(2.2));
        System.out.print("My number is ");
        System.out.print(myNumber.getNumerator());
        System.out.print(" / ");
        System.out.print(myNumber.getDenominator());
        System.out.print(" (");
        System.out.print(Double.toString((double)myNumber.getNumerator()/(double)myNumber.getDenominator()));
        System.out.println(")");
        System.out.print("Operation result is ");
        System.out.print(myOtherNumber.getNumerator());
        System.out.print(" / ");
        System.out.print(myOtherNumber.getDenominator());
        System.out.print(" (");
        System.out.print(Double.toString((double)myOtherNumber.getNumerator()/(double)myOtherNumber.getDenominator()));
        System.out.println(")");
        PrimeCollection prime = new PrimeCollection();
        for (int value : prime) {
            System.out.print(Integer.toString(value));
            System.out.print(", ");
            if (value>100) break;
        }
    }
}
