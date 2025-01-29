package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortQuestions {
    public static int minCostElementRemoval (Integer[] ar) {
        Arrays.sort(ar, Collections.reverseOrder());
        int ans = 0;
        for(int i = 0; i < ar.length; i++) {
            ans += ar[i] * (i+1);
        }
        return ans;
    }

    public static int nobleIntegers(Integer[] ar) {
        Arrays.sort(ar);
        int ans = 0;
        int count_smaller = 0;

        if(ar[0] == 0) ans++;

        for(int i = 1; i < ar.length; i++) {
            if(ar[i] != ar[i-1]) {
                count_smaller = i;
            }
            if(ar[i] == count_smaller) {
                ans++;
            }
        }
        if(ans > 0) return ans;
        else return -1;
    }

    public static int reverseNobelInteger(ArrayList<Integer> A) {
        System.out.println("original " + A);
        Collections.sort(A);
        System.out.println("after sort " + A);

        int n = A.size();
        int ans = 0;


        if(A.get(0) == (n - 1)) {
            ans++;
        }

        for(int i = 1; i < n; i++) {
            if(A.get(i) == (n-i)) ans++;
        }
        if(ans > 0) return ans;
        else return -1;
    }

    public static int kthsmallest(final List<Integer> A, int B) {
        Collections.sort(A);

        return A.get(B -1);
    }

    public static void main(String[] args) {
//        Integer[] a = {3,5,1,-3,5,2,4,3,12,31,542};
//        System.out.println(minCostElementRemoval(a));
//
//        int[] n = {1,-5,3,5,-10,4};
//        Integer[] nn = Arrays.stream(n).boxed().toArray(Integer[]::new);
//        System.out.println(nobleIntegers(nn));

//        int[] q = {8,16,80,55,32,8,38,40,65,18,15,45,50,38,54,52,23,74,81,42,28,16,66,35,91,36,44,9,85,58,59,49,75,20,87,60,17,11,39,62,20,17,46,26,81,92};
//        List<Integer> l = Arrays.stream(q).boxed().collect(Collectors.toList());
//        System.out.println(kthsmallest(l,9));

        Integer[] ab = {-4,7,5,3,5,-4,2,-1,-9,-8,-3,0,9,-7,-4,-10,-4,2,6,1,-2,-3,-1,-8,0,-8,-7,-3,5,-1,-8,-8,8,-1,-3,3,6,1,-8,-1,3,-9,9,-6,7,8,-6,5,0,3,-4,1,-10,6,3,-8,0,6,-9,-5,-5,-6,-3,6,-5,-4,-1,3,7,-6,5,-8,-5,4,-3,4,-6,-7,0,-3,-2,6,8,-2,-6,-7,1,4,9,2,-10,6,-2,9,2,-4,-4,4,9,5,0,4,8,-3,-9,7,-8,7,2,2,6,-9,-10,-4,-9,-5,-1,-6,9,-10,-1,1,7,7,1,-9,5,-1,-3,-3,6,7,3,-4,-5,-4,-7,9,-6,-2,1,2,-1,-7,9,0,-2,-2,5,-10,-1,6,-7,8,-5,-4,1,-9,5,9,-2,-6,-2,-9,0,3,-10,4,-6,-6,4,-3,6,-7,1,-3,-5,9,6,2,1,7,-2,5};
        Integer[] aa = {-4,2,0,-1,-6};
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ar.addAll(Arrays.asList(aa));
        System.out.println(reverseNobelInteger(ar));
    }
}
