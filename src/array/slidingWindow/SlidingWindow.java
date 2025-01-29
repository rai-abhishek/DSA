package array.slidingWindow;

/**
 * Given arr[N]. Print maximum subarray sum of subarray with length k.
 */
public class SlidingWindow {

    public static long slidingWindowBruteForce(int[] A, int k) {
        int ans = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = k-1;
        int n = A.length;

        while (endIndex < n) {
            int sum = 0;
            for(int i = startIndex; i <= endIndex;i++) {
                sum += A[i];
                ans = Math.max(ans,sum);
            }
            startIndex++;
            endIndex++;
        }
        return ans;
    }

    public static long usingPrefixsum(int[] A, int k) {

        int n = A.length;
        int[] prefixSum = new int[n];

        //create prefix sum array
        prefixSum[0] = A[0];

        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        int ans = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = k - 1;

        while (endIndex < n) {
            int sum = 0;
            if(startIndex == 0) sum = prefixSum[endIndex];
            else sum = prefixSum[endIndex] - prefixSum[startIndex -1];
            ans = Math.max(ans,sum);
            startIndex++;
            endIndex++;
        }
        return ans;
    }

    public static long slidingWindowWhileLoop(int[] A, int k) {
        // create the window
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        int n = A.length;
        for(int i = 0; i < k; i++) {
            sum += A[i];
        }

        //slide the window
        int startIndex = 1;
        int endIndex = k;
        while (endIndex < n) {
            /** Sliding Window will maintain the same array length, but it will keep on sliding
             * remove the first element from the sum and add the last element to the sum
              */
            sum = sum  - A[startIndex -1] + A[endIndex];
            ans = Math.max(ans,sum);
            startIndex++;
            endIndex++;
        }
        return ans;
    }

    public static long slidingWindowForLoop(int[] A, int k) {
        //create the window
        int n = A.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += A[i];
        }

        ans = sum;

        //slide the window
        for(int startIndex = 1, endIndex = k; endIndex < n; startIndex++,endIndex++) {
            sum = sum - A[startIndex - 1] + A[endIndex];
            ans = Math.max(ans,sum);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] n = {-3,4,-2,5,3,-2,8,2,-1,4};
        int k = 5;
        System.out.println("----Using Brute Force----");
        System.out.println(slidingWindowBruteForce(n,k));

        System.out.println("----Using prefix sum----");
        System.out.println(usingPrefixsum(n,k));

        System.out.println("----Using Sliding Window with While loop----");
        System.out.println(slidingWindowWhileLoop(n,k));

        System.out.println("----Using Sliding Window with for loop----");
        System.out.println(slidingWindowForLoop(n,k));

    }
}
