package leetCodeTop75;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 * <p>
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 * <p>
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
public class MergeString1768 {
    public static String mergeString(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        int l1 = word1.length();
        int l2 = word2.length();

        StringBuilder s = new StringBuilder();
        while (p1 < l1 || p2 < l2) {
            if (p1 < l1) {
                if (word1.charAt(p1) != ' ') {
                    s.append(String.valueOf(word1.charAt(p1)));
                }
            }

            if (p2 < l2) {
                if (word2.charAt(p2) != ' ') {
                    s.append(String.valueOf(word2.charAt(p2)));
                }
            }
            p1++;
            p2++;
        }


        return s.toString();
    }

    public static void main(String[] args) {
        String w1 = "ab";
        String w2 = "pqrs";
        System.out.println(mergeString(w1, w2));
    }
}
