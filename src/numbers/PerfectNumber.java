package numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * You are given an integer A. You have to tell whether it is a perfect number or not.
 * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
 * A proper divisor of a natural number is the divisor that is strictly less than the number.
 * Explanation 1:
 * For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
 * Explanation 2:
 * For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
 */
public class PerfectNumber {
    public static int perfectNumber(int A) {
        Set<Object> ss = new HashSet<>();

        for(int i = 1; i < A; i++) {
            if (A % i == 0) {
                ss.add(i);
            }
        }
        Iterator i = ss.iterator();
        int sum =0;
        while(i.hasNext()) {
            sum += (int) i.next();
        }

        if(sum == A) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(perfectNumber(6));
    }
}
