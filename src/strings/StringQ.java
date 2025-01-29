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

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
}
