package strings;

public class StringQ {
    public static boolean isSubsequence(String s, String t) {
        // using two pointer because we have two strings to compare
        int sPointer = 0;
        int tpointer = 0;

        while(sPointer < s.length() && tpointer < t.length()) {
            if(s.charAt(sPointer) == t.charAt(tpointer)) {
                sPointer++;
            }
            tpointer++;
        }

        return sPointer == s.length();
    }

    public static String lowerToUpperAndVisaVersa(String s) {
        int n = s.length();
        char[] ans = new char[n];
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                ans[i] = (char)(s.charAt(i) - 32);
            } else {
                ans[i] = (char)(s.charAt(i) + 32);
            }
        }
        return new String(ans);
    }

    public static boolean isPalindrome(String s, int si, int ei) {
        while(si < ei) {
            if(s.charAt(si) != s.charAt(ei)) {
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }

    /**
     * Given a String s, find the longest palindrome substring in s
     *
     */
    public static int bfLongestPalindromeSubstring(String s) {
        int maxLength = 1;
        int n = s.length();
        for(int i = 0; i < n;i++) {
            for(int j = i; j < n;j++) {
                if(isPalindrome(s,i,j) == true) {
                    maxLength = Math.max(maxLength,j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static int longestPalindromeSubstring(String s) {
        int ans = 1;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int oddMaxLength = expand(s,i,i);
            int evenMaxLength = expand(s,i,i+1);
            ans = Math.max(ans,Math.max(oddMaxLength,evenMaxLength));
        }
        return ans;
    }

    public static int expand(String s, int l, int r) {
        while(l >= 0 && r < s.length()) {
            if(s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * You are given a string A of size N.
     *
     *
     * Return the string A after reversing the string word by word.
     *
     * NOTE:
     *
     * A sequence of non-space characters constitutes a word.
     * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
     * If there are multiple spaces between words, reduce them to a single space in the reversed string.
     *
     */
    public static String reverseEachString(String A) {
        A = A.replaceAll("\\s+"," ").trim();
        String[] res = A.split(" ");
        int n = res.length;
        StringBuilder ans = new StringBuilder();

        ans.append(res[n - 1]);
        for(int i=0; i < n -1;i++) {
            ans.append(" " + res[n - i -1]);
        }
        return ans.toString();
    }

    public static String reverse(String s) {
        int n = s.length();
        char[] ans = new char[n];

        for(int i=0; i < n;i++) {
            ans[i] = s.charAt(n -  i - 1);
        }
        return new String(ans);
    }

    public static void main(String[] args) {
//        String s = "abc";
//        String t = "ahbgdc";
//        System.out.println(isSubsequence(s,t));
//
//        String s1 = "abABaaBB";
//        System.out.println(lowerToUpperAndVisaVersa(s1));
//
//        String s2 = "madam";
//        System.out.println(isPalindrome(s2,0,s2.length()-1));
//
//        String s3 = "adaebcdfdcbetgge";
//        System.out.println(bfLongestPalindromeSubstring(s3));
//
//        System.out.println(longestPalindromeSubstring(s3));

        String s8 = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv";
        System.out.println(reverseEachString(s8));
    }
}
