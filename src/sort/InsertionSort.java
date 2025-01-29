package sort;

import java.util.Arrays;

/**
 * Arrangement of playing cards
 */
public class InsertionSort {
    public static void  insertionSortInt(int[] a) {
        int n = a.length;
        int temp = 0;

        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                //for each i, check if the j is smaller than previous value, if yes then swap or else break
                if(a[j-1] > a[j]) {
                    // swap
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]  n = {5,6,4,2,1,3,5,6,10};
        int[] q = {8,16,80,55,32,8,38,40,65,18,15,45,50,38,54,52,23,74,81,42,28,16,66,35,91,36,44,9,85,58,59,49,75,20,87,60,17,11,39,62,20,17,46,26,81,92};
        System.out.println(Arrays.toString(q));
        insertionSortInt(q);
        System.out.println(Arrays.toString(q));

    }
}
