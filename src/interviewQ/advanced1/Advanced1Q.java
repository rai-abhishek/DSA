package interviewQ.advanced1;


public class Advanced1Q {
    /**
     * <h1>continuous Sum Query</h1>
     * Initially all the elements of an arr[n] are zeros. Then you are given Q queries. Every query contains i-idx and values
     * Increment element from ith idx to last idx by value. Return final state of arr[].
     */
    public static int[] continuousSumQuery(int[] arr, int[][] Q) {
        for(int i = 0; i < Q.length; i++) {
            int idx = Q[i][0];
            int val = Q[i][1];

            arr[idx] = val;
        }

        int[] psum = new int[arr.length];
        psum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            psum[i] = psum[i-1] + arr[i];
        }
        return psum;
    }

    /**
     * <h1>continuous Sum Query in range</h1>
     * Initially all the elements of an arr[n] are zeros. Then you are given Q queries. Every query contains [s,e,val] and values
     * Increment element from ith idx to last idx by value. Return final state of arr[].
     */
    public static int[] continuousSumQueryInRange(int[] arr, int[][] Q) {
        for(int i = 0; i < Q.length; i++) {
            int si = Q[i][0];
            int ei = Q[i][1];
            int val = Q[i][2];

            arr[si] += val;
            if(ei < arr.length - 1) {
                arr[ei+ 1] -= val;
            }
        }

        int[] psum = new int[arr.length];
        psum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            psum[i] = psum[i-1] + arr[i];
        }
        return psum;
    }

    /**
     * <H1>water trapped</H1>
     * given arr[i] where i is the height of the building
     * Return amount of water trapped on all the buildings.
     * Amount of water trapped = Min(left_max, right_max) - arr[i]
     */

    public static int waterTrapped(int[] arr) {
        int n = arr.length;
        //create lmax
        int[] lmax = new int[n];
        lmax[0] = arr[0];

        for(int i = 1; i < n;i++) {
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }
        //create rmax
        int[] rmax = new int[n];
        rmax[n - 1] = arr[n-1];
        for(int i = n - 2; i >=0; i--) {
            rmax[i] = Math.max(rmax[i + 1],arr[i]);
        }

        //compute formula
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.min(lmax[i],rmax[i]) - arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n = {0,0,0,0,0,0,0};
        int[][] queries = {
                {3,4},
                {1,3},
                {4,-2}
        };
        int[] res = continuousSumQuery(n,queries);
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[][] q = {
                {1,4, 3},
                {0,5,-1},
                {2,2,4},
                {4,6,3}
        };
        int[] n1 = {0,0,0,0,0,0,0,0};
        int[] res1 = continuousSumQueryInRange(n1,q);
        for(int i : res1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] a = {4,2,5,7,4,2,3,6,8,2,3};
        System.out.println(waterTrapped(a));
    }
}
