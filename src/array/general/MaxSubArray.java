package array.general;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 * Input 1:
 * A = 5
 * B = 12
 * C = [2, 1, 3, 4, 5]
 * Input 2:
 *
 * A = 3
 * B = 1
 * C = [2, 2, 2]
 *
 *
 * Example Output
 * Output 1:
 * 12
 * Output 2:
 *
 * 0
 */
public class MaxSubArray {
    public static int maxSubarray(int A, int B, ArrayList<Integer> C) {
        // A = array length
        // B = subarray sum
        int currentSum = 0;
        int maxSum = 0;
        int start = 0;

        for(int end = 0; end < A; end++) {
            // add current element to sum
            currentSum += C.get(end);

            // if the current element exceeds B, remove element from the start.
            while(currentSum > B && start <= end) {
                currentSum -= C.get(start);
                start++;
            }
            // update max sum
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Integer[] A = {2,1,3,4,5};
        Integer[] AA = {8,7};
        int N = 5;
        int B = 12;
        int N1 = 2;
        int B1 = 4;
        ArrayList<Integer> aa = new ArrayList<Integer>();
        aa.addAll(Arrays.asList(AA));
        System.out.println(maxSubarray(N1,B1,aa));
    }
}
