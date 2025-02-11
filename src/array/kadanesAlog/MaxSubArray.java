package array.kadanesAlog;

import java.util.Arrays;

public class MaxSubArray {
    public static int maxSubArraySumBF(int[] a) {
        int n = a.length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n;j++) {
                int sum = 0;
                for(int k = i; k < j;k++) {
                    sum += a[k];
                }
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    public static int maxSubArraySumPrefixSum(int[] a) {
        int n  = a.length;
        int[] psum = new int[n];

        psum[0] = a[0];
        for(int i = 1; i < n; i++) {
            psum[i] = psum[i-1] + a[i];
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n;i++) {
            for(int j = i; j <n; j++) {
                int sum = 0;
                if(i == 0) {
                    sum = psum[j];
                } else {
                    sum = psum[j] - psum[i -1];
                }
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    public static int maxSubArraySumCarryForward(int[] a) {
        int n = a.length;
        int ans = Integer.MIN_VALUE;

        for(int i =0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += a[j];
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    public static int maxSubArraySumKadanesAlgo(int[] a) {
        int n = a.length;
        int ans = Integer.MIN_VALUE, sum = 0;

        for(int i = 0; i < n; i++) {
            sum += a[i];
            ans = Math.max(ans, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    /**
     * return the max of sub array using Kadanes algo
     * <h1>observation -</h1>
     * SI = i till the sum is positive
     * ei will eb the carry forward i
     * SI will initialise to new i when the sum < 0
     */
    public static int[] maxsubArrayKadanesAlgo(int[] a) {
        int n = a.length;
        int ans = Integer.MIN_VALUE, sum =0, si = 0,ei = 0;

        for(int i = 0; i  < n; i++) {
            ei = i;
            sum += a[i];
            ans = Math.max(ans,sum);
            if(sum < 0) {
                sum = 0;
                if(i == n - 1) {
                    si = i;
                } else {
                    si = i + 1;
                }
            }
        }
        return Arrays.copyOfRange(a,si,ei);
    }


    public static void main(String[] args) {
        int[] n = {5,6,7,-3,2,-10,-12,8,12,-4,7,-2};

        System.out.println(maxSubArraySumBF(n));
        System.out.println(maxSubArraySumPrefixSum(n));
        System.out.println(maxSubArraySumCarryForward(n));
        System.out.println(maxSubArraySumKadanesAlgo(n));
        int[] res = maxsubArrayKadanesAlgo(n);

        for(int i :  res) {
            System.out.print(i + " ");
        }
    }
}
