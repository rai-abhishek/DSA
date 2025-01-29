package array.carryForward;

import java.util.ArrayList;
import java.util.Arrays;

public class CarryForward {
    CarryForward() {};

    /**
     * given a string of lowercase characters, return the count of pairs (i,j) such that i < j
     * and s[i] = 'a' and s[j] = 'g'
     * approach - start from right to left side - count g and if corrosponding a is found, increase the answer
     * similar approach from left to right
     */
    public int agPairFromRight(char[] ar) {
        System.out.println(ar);
        int count = 0;
        int ans = 0;

        for(int i = ar.length - 1; i >= 0; i--) {
            if(ar[i] == 'g') {
                count++;
            } else if(ar[i] == 'a') {
                ans += count;
            }
        }
        return ans;
    }

    public int agPairFromLeft(char[] ar) {
        int count = 0;
        int ans = 0;

        for(int i = 0; i < ar.length; i++){
            if(ar[i] == 'a') {
                count++;
            } else if (ar[i] == 'g') {
                ans += count;
            }
        }
        return ans;
    }

    public long carryForwardString(String A) {
        System.out.println(A);
        long count = 0;
        long answer = 0;

        // using left side traversal
        for(int i = 0; i < A.length();i++) {
            if(A.charAt(i) == 'G') {
                count++;
            } else if (A.charAt(i) == 'A') {
                answer += count;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
         char[] s = {'a','c','b','a','g','k','a','g','g'};
         char[] s1 = {'b','c','a','g','g','a','a','g'};
         String ss = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";

         CarryForward c = new CarryForward();
         System.out.println(c.agPairFromRight(s));
         System.out.println(c.agPairFromLeft(s));
        System.out.println(c.agPairFromRight(s1));
        System.out.println(c.carryForwardString(ss));
    }

}
