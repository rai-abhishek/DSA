package array.general;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 5 x 103
 * 1 <= A[i] <= 103
 * 1 <= B <= 107
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is an integer B.
 * <p>
 * <p>
 * Output Format
 * Return the count of good subarrays in A.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 4
 * Input 2:
 * <p>
 * A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
 * B = 65
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * <p>
 * 36
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * Even length good subarrays = {1, 2}
 * Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
 * Explanation 1:
 * There are 36 good subarrays
 */
public class GoodSubarrays {
    public static int goodSubArray(ArrayList<Integer> A, int B) {
        int count = 0;
        int sum = 0;
        int n = A.size();

        // even count
        for(int i = 0;i < n; i +=2) {
            if(i % 2 == 0) {
                sum += A.get(i);
                if(sum < B) count++;
            }
        }

        // odd count
        sum = 0;
        for(int i = 1;i < n; i +=2) {
            if(i % 2 != 0) {
                sum += A.get(i);
                if(sum > B) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer[] n = {1,2,3,4,5};
        int b = 4;
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.addAll(Arrays.asList(n));
        System.out.println(goodSubArray(a,b));
    }
}
