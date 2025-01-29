package array.slidingWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;

/**
 * Problem Description
 * Given an array A of size N, find the subarray of size B with the least average.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= B <= N <= 105
 * -105 <= A[i] <= 105
 * <p>
 * <p>
 * Input Format
 * First argument contains an array A of integers of size N.
 * Second argument contains integer B.
 * <p>
 * <p>
 * Output Format
 * Return the index of the first element of the subarray of size B that has least average.
 * Array indexing starts from 0.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [3, 7, 90, 20, 10, 50, 40]
 * B = 3
 * Input 2:
 * <p>
 * A = [3, 7, 5, 20, -10, 0, 12]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * <p>
 * 4
 */
public class LeastAverageSubArray {

    public static int leastAverageSubArray(ArrayList<Integer> A, int B) {
        // Least average is equivalent to least sum
        int N = A.size();

        if (B > N) {
            return 0;
        }

        // Initialize variables
        int minSum = 0;
        int currentSum = 0;
        int startIndex = 0;

        // Calculate the sum of the first window of size B
        int start = 0;
        while (start < B) {
            currentSum += A.get(start);
            start++;
        }

        // Set the minimum sum to the sum of the first window
        minSum = currentSum;

        // Slide the window across the array
        while (start < N) {
            currentSum = currentSum - A.get(start - B) + A.get(start);

            // Update the minimum sum and starting index if a smaller sum is found
            if (currentSum < minSum) {
                minSum = currentSum;
                startIndex = start - B + 1;
            }
            start++;
        }

        return startIndex;
    }

    public static void main(String[] args) {
        Integer[] n = {3, 7, 90, 20, 10, 50, 40};
        Integer[] nn = {18, 11, 16, 19, 11, 9, 8, 15, 3, 10, 9, 20, 1, 19};
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.addAll(Arrays.asList(n));
        System.out.println(leastAverageSubArray(a, 3));
    }
}

