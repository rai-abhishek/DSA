package array.subarrays;

import java.util.ArrayList;

public class PrintSubArrays {
    public static void print(int[] ar) {
        for(int m : ar) {
            System.out.print(m + " ");
        }
        System.out.println();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < ar.length; i++) {
            for(int j = i; j < ar.length; j++) {
                ArrayList<Integer> al = new ArrayList<Integer>();
                for(int k = i; k <= j; k++){
                    al.add(ar[k]);
                }
                ans.add(al);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] n = {36,63,63,26,87,77,93,7};
        print(n);
    }
}
