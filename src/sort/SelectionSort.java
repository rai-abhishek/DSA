package sort;

import java.util.Arrays;

/**
 * select the minimum element (index) and send that elements to correct position by swapping
 */
public class SelectionSort {
    public static void selectionSortInt(int[] a) {
        int n = a.length;
        int min_idx = 0;
        int temp = 0;

        for(int i = 0; i < n-1; i++) {
            min_idx = i;
            // find the minimum index for the smallest element in the array
            for(int j = i + 1; j < n; j++) {
                if(a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }
            //swap the element with i
            temp = a[i];
            a[i] = a[min_idx];
            a[min_idx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] n = {5,6,4,2,5,3};
        System.out.println(Arrays.toString(n));
        selectionSortInt(n);
        System.out.println(Arrays.toString(n));

    }
}
