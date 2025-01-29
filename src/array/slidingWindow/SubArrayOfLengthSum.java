package array.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an array A of length N. Also given are integers B and C.
 *
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 104
 *
 * 1 <= B <= N
 *
 * 1 <= C <= 109
 *
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 * The remaining arguments B and C are integers
 *
 *
 *
 * Output Format
 * Return 1 if such a subarray exist and 0 otherwise
 *
 *
 * Example Input
 * Input 1:
 * A = [4, 3, 2, 6, 1]
 * B = 3
 * C = 11
 * Input 2:
 *
 * A = [4, 2, 2, 5, 1]
 * B = 4
 * C = 6
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 *
 * 0
 */
public class SubArrayOfLengthSum {
    public static int solve(ArrayList<Integer> A, int B, int C) {
        // Subarray Length = B
        // Subarray sum = C

        int n = A.size();
        if(n == 1) return 1;

        int ans = 0;
        int currentSum = 0;
        // create window
        for(int i = 0; i < B ; i++) {
            currentSum += A.get(i);
        }

        ans = currentSum;
        if(ans == C) return 1;

        int si = 1;
        int ei = B;

        while(ei < n) {
            currentSum = currentSum - A.get(si -1) + A.get(ei);
            ans = currentSum;
            si++;
            ei++;
            if(ans == C) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        Integer[] n = {6,3,3,6,7,8,7,3,7};
        Integer[] n1 = {6};
        A.addAll(Arrays.asList(n1));
        int B = 1;
        int C = 6;
        System.out.println( solve(A,B,C));
    }
}
