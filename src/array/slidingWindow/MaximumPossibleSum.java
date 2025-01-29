package array.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPossibleSum {
    public static int maxPossibleSum(ArrayList<Integer> A, int B) {
        int currentSum = 0;
        int n = A.size();

        //calculate the left to right sum
        for(int i = 0; i < B ;i++) {
            currentSum += A.get(i);
        }

        int maxSum = currentSum;

        /** From the current sum, remove the last value and add the right most value
         * if the current sum > max sum, update the max Sum
         *
         */
        for(int i = 0; i < B; i++) {
            currentSum = currentSum - A.get(B - 1 - i) + A.get(n - 1 - i);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Integer[] n = {5, -2, 3 , 1, 2};
        Integer[] n1 = {2,3,-1,4,2,1};
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.addAll(Arrays.asList(n1));
        System.out.println(maxPossibleSum(a,4));
    }
}
