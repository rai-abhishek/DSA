package sort;

public class CountSort {

    public static int[] countSort(int[] ar) {
        int[] farray = new int[ar.length];

        for(int i = 0; i < ar.length; i++) {
            int val = ar[i];
            farray[val]++;
        }

        int k = 0;
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j < farray[i]; j++) {
                ar[k] = i;
                k++;
            }
        }
        return ar;
    }

    public  static int[] countSortNegativeNumbers(int[] ar) {
        // find min max
        int min = 0, max = 0;
        for(int i = 0; i < ar.length;i++) {
            min = Math.min(min,ar[i]);
            max = Math.max(max,ar[i]);
        }
        // create farray
        int[] farray = new int[max - min + 1];

        // sort
        int k = 0;
        for(int i = 0; i < farray.length;i++) {
            int count = farray[i];
            for(int j = 0; j < count;j++) {
                ar[k] = i;
                k++;
            }
        }
        return ar;
    }

    public static void main(String[] args) {

        int[] a = {9, 1, 2, 5,4,2,1,2,5,8};
        int[] b = {5, 2, -3, 4,-2,9,-1,2};
        System.out.println("------" + "count sort" + "------");
        int[] res = countSort(a);
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("------" + "count sort including negative number" + "------");
        int[] res1 = countSortNegativeNumbers(b);
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
