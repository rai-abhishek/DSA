package array.twoPointer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SumOfMaxMin {
    SumOfMaxMin() {};

//    public int bruteForce(ArrayList<Integer> A) {
//        int max = 0;
//        int min = 0;
//        int left = 0;
//        int right = A.size() -1 ;
//
//        while(left < right) {
//            System.out.println(A.get(left) + "_" + A.get(right));
//            if(A.get(left).equals()) {
//                max = left;
//                min = right;
//            }
//            left++;
//            right--;
//        }
//        return max + min;
//    }

    public int usingSort(ArrayList<Integer> A) {
        A.sort(null);
        return A.get(0) + A.get(A.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        SumOfMaxMin s = new SumOfMaxMin();
        Integer[] n = {-2,1,-4,5,3};
        Integer[] nn = {1,3,4,1};
        a.addAll(Arrays.asList(n));

        System.out.println(a);
        System.out.println("Using sort: " + s.usingSort(a));
//        System.out.println("Using Brute Force: " + s.bruteForce(a));

        a.clear();
        a.addAll(Arrays.asList(nn));
        System.out.println(a);
        System.out.println("Using sort: " + s.usingSort(a));
//        System.out.println("Using Brute Force: " + s.bruteForce(a));

    }
}
