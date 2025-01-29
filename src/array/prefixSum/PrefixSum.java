package array.prefixSum;

import java.util.Arrays;

public class PrefixSum {
    PrefixSum() {};

    public void bruteForce(int[] ar,int[][] q) {
        System.out.println("------------Using Brute Force------------");
        for(int i=0; i <= q.length - 1; i++) {
            int l = q[i][0];
            int r = q[i][1];

            int sum = 0;
            for(int j = l; j <= r; j++) {
                sum += ar[j];
            }
            System.out.println("Query (" + l + "," + r + ") sum is: " + sum);

        }
    }

    public void prefixSum(int[] ar,int[][] q) {
        System.out.println("------------Using Prefix Sum array------------");
        int[] psum = new int[ar.length];
        psum[0] = ar[0];

        for (int i = 1; i < ar.length; i++) {
            psum[i] = psum[i-1] + ar[i];
        }

        for(int i = 0; i < q.length; i++) {
            int l = q[i][0];
            int r = q[i][1];

            if(l == 0) {
                System.out.println("Query (" + l + "," + r + ") sum is: " + psum[r]);
            } else {
                int res = psum[r] - psum[l-1];
                System.out.println("Query (" + l + "," + r + ") sum is: " + res);
            }
        }
    }

    public void prefixSumUsingSameArray(int[] ar,int[][] q){
        System.out.println("------------Prefix Sum using same array------------");
        for(int i = 1; i < ar.length;i++) {
            ar[i]= ar[i-1] + ar[i];
        }

        for(int i = 0; i < q.length; i++) {
            int l = q[i][0];
            int r = q[i][1];

            if(l == 0) {
                System.out.println("Query (" + l + "," + r + ") sum is: " + ar[r]);
            } else {
                int res = ar[r] - ar[l-1];
                System.out.println("Query (" + l + "," + r + ") sum is: " + res);
            }
        }

    }

    public static void main(String[] args) {
        int[] n = {-3, 6,2,4,5,2,8,-9,3,1};
        int[][] qq = {{4,8},{3,7},{1,3},{0,4},{7,7}};

        PrefixSum p = new PrefixSum();
        p.bruteForce(n,qq);
        p.prefixSum(n,qq);
        p.prefixSumUsingSameArray(n,qq);
    }
}
