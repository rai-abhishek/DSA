package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int pivotIndex(int[] nums) {
        int[] psum = new int[nums.length];
        psum[0] = nums[0];
        int n = psum.length;

        for(int i = 1; i < n;i++) {
            psum[i] = psum[i-1] + nums[i];
        }

        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                leftSum = 0;
                rightSum = psum[n - 1] - psum[0];
            } else if(i == n-1) {
                leftSum = psum[i - 1];
                rightSum = 0;
            } else {
                leftSum = psum[i - 1];
                rightSum = psum[n - 1] - psum[i];
            }

            if( leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] n = {1,7,3,6,5,6};
//        int ans = pivotIndex(n);
//        System.out.println(ans);

        System.out.println();
    }
}


