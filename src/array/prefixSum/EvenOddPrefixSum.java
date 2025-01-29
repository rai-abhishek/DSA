package array.prefixSum;

/**
 * Given an ar[N] and Q queries with start(s) and end(e) index. For every query print sum of all even indexed
 * elements from s to e.
 */

public class EvenOddPrefixSum {
    EvenOddPrefixSum() {};

    public void evenPrefixSum(int[] ar, int[][] q) {
        int[] psum = new int[ar.length];
        psum[0] = ar[0];

        for(int i = 1; i< ar.length; i++) {
            if(i % 2 == 0) {
                psum[i] = psum[i-1] + ar[i];
            } else {
                psum[i] = psum[i-1];
            }
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

    public void oddPrefixSum(int[] ar, int[][]q) {
        int[] psum = new int[ar.length];

        if(ar[0] % 2 == 0 ) {
            psum[0] = 0;
        } else {
            psum[0] = ar[0];
        }

        for(int i = 1; i < ar.length; i++) {
            if(i % 2 != 0) {
                psum[i] = psum[i-1] + ar[i];
            } else {
                psum[i] = psum[i-1];
            }
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



    public static void main(String[] args) {
        EvenOddPrefixSum e = new EvenOddPrefixSum();

        int[] n  = {2,3,1,6,4,5};
        System.out.println("Original");
        for(int j: n) {
            System.out.print(j + " ");
        }
        System.out.println();

        int[][] qq = {{1,3},{2,5},{0,4},{3,3}};

        System.out.println("---------------- Even Prefix sum ----------------");
        e.evenPrefixSum(n,qq);
        System.out.println("---------------- Odd Prefix sum ----------------");
        e.oddPrefixSum(n,qq);

    }
}
