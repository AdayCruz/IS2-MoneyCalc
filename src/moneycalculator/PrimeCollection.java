package moneycalculator;

import java.util.Iterator;

public class PrimeCollection implements Iterable<Integer> {

    private int number = 1;

    @Override
    public Iterator<Integer> iterator() {
        
        return new Iterator<Integer>() {
            
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                number = calculateNextPrime(number);
                return number;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            private int calculateNextPrime(int number) {
                while (true) {
                    number++;
                    if (isPrime(number)) return number;
                }
            }

            private boolean isPrime(int number) {
                for (int i = 2; i < number -1 ; i++) {
                    if (number % i == 0) return false;
                }
                return true;
            }
        };

    }
}
