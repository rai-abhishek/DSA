package array.contribution;

/**
 * Given an array arr[N]. Find the sum of all Sub arrays sums
 */

public class Contribution {

    public static int sumOfSubArraysBF(int[] A) {
        int n = A.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += A[k];
                }
                ans += sum;
            }
        }
        return ans;
    }

    public static int sumOfSubArraysPrefixSum(int[] A) {
        int n = A.length;
        int ans = 0;

        // create prefix sum
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

//        calculate sub array sum
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                if(i == 0) {
                    sum = prefixSum[j];
                }
                else {
                    sum = prefixSum[j] - prefixSum[i-1];
                }
                ans += sum;
            }
        }
        return ans;
    }

    public static int sumOfSubArraysCarryForward(int[] A) {
        int n = A.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += A[j];
                ans += sum;
            }
        }
        return ans;
    }

    public static long sumOfSubArraysUsingObservation(int[] A) {
        int n = A.length;
        long ans = 0;
        // contribution of ith element in array = (i + 1) * (n -i)

        for(int i = 0; i < n; i++) {
            ans += (long) (i + 1) * (n -i) * A[i];
        }
        return ans;
    };


    public static void main(String[] args) {
        int[] n = {1,2,3};
        int[] nn = {3,-2,1,4};
        System.out.println("----Using Brute Force----");
        System.out.println(sumOfSubArraysBF(n));
        System.out.println(sumOfSubArraysBF(nn));

        System.out.println("----Using Prefix Sum----");
        System.out.println(sumOfSubArraysPrefixSum(n));
        System.out.println(sumOfSubArraysPrefixSum(nn));

        System.out.println("----Using Carry Forward----");
        System.out.println(sumOfSubArraysCarryForward(n));
        System.out.println(sumOfSubArraysCarryForward(nn));

        System.out.println("----Using Observation----");
        System.out.println(sumOfSubArraysUsingObservation(n));
        System.out.println(sumOfSubArraysUsingObservation(nn));
    }
}
