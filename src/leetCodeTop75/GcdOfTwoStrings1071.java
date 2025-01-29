package leetCodeTop75;

import java.util.HashMap;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */

public class GcdOfTwoStrings1071 {
    public static String gcdOfStrings(String str1, String str2) {
//        if concat does not work, then there is no common divisor
        if(!(str1 + str2).equals(str2 + str1)) return "";

        //calculate the GCD of two strings
        int gcdLength = gcd(str1.length(),str2.length());

        //the substring using the GCD length is the first Answer
        String initialAns =  str1.substring(0,gcdLength);

        // see further if the divisor can be divided
        String futherDevide = str2.substring(0,str2.length() / 2);

        if((str1 + futherDevide).equals(futherDevide + str1)) {
            return futherDevide;
        } else return initialAns;
    }

    private static int gcd(int a, int b) {
        while( b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        String s1 = "ABABABABABABABAB";
        String s2 = "ABAB";
        System.out.println(gcdOfStrings(s1,s2));

        String s3 = "ABCABCABC";
        String s4 = "ABC";
        System.out.println(gcdOfStrings(s3,s4));

        String s5 = "ABCDABCDABCD";
        String s6 = "ABCD";
        System.out.println(gcdOfStrings(s5,s6));
    }
}
