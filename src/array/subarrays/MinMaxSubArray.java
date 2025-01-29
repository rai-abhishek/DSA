package array.subarrays;

public class MinMaxSubArray {
    MinMaxSubArray() {
    }

    ;

    /**
     * given an array of N integers, return the length of smallest subarray which contains
     * both maximum and minimum elements of the array
     * a = [2 2 6 4 5 1 5 2 6 4 1] , ans = 3 (6,4,1)
     */
    public int minMax(int[] ar) {
        // find min & max
        int min = ar[0];
        int max = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }
            if (ar[i] < min) {
                min = ar[i];
            }
        }
        System.out.println("min_max: " + min + "_" + max);

        if (min == max) return 1;
        // Create two variables for index of min and max and a variable for answer. Update  min and max using
        // carry forward.
        int idx_min = -1;
        int idx_max = -1;
        int ans = ar.length;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == min) {
                idx_min = i;
                if (idx_max != -1) {
                    ans = Math.min(ans, i - idx_max + 1);
                }
            } else if (ar[i] == max) {
                idx_max = i;
                if (idx_min != -1) {
                    ans = Math.min(ans, i - idx_min + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinMaxSubArray m = new MinMaxSubArray();
        int[] n = {2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1};
        int[] nn = {1,2, 3, 1, 3, 4, 6, 4, 6, 3};

        System.out.println(m.minMax(n));
        System.out.println(m.minMax(nn));

    }
}
