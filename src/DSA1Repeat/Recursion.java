package DSA1Repeat;

import java.util.ArrayList;
import java.util.Arrays;


public class Recursion {

    public static ArrayList<Integer> allIndices(ArrayList<Integer> A, int B) {
        return checkNum(A,B,0,0);
    }

    public static ArrayList<Integer> checkNum(ArrayList<Integer> A ,int B, int idx, int cnt) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(idx == A.size()) return ans;


        if(A.get(idx) == B) {
            ans = checkNum(A,B, idx + 1, cnt + 1);
            ans.set(cnt,idx);
            return ans;
        } else {
            ans = checkNum(A,B, idx + 1, cnt);
            return ans;
        }
    }

    public static int intSum(int A) {
        int res = reduceSum(A);
        if(res == 1) return 1;
        else return 0;
    }


    public static int sumDigit(int A) {
        if(A == 0) return 0;
        return sumDigit(A / 10) + A % 10;
    }

    public static int reduceSum(int n) {
        if(n < 10) return n;

        return reduceSum(sumDigit(n));
    }



    public static void main(String[] args) {
//            ArrayList<Integer> a = new ArrayList<>();
//            ArrayList<Integer> d = new ArrayList<>();
//            Integer[] b = {1,2,3,4,5};
//            int c = 1;
//            a.addAll(Arrays.asList(b));
//
//            d = allIndices(a,c);
//        System.out.println(d);
        int n = 83557;

//        System.out.println(intSum(n));
        int ab = -40;
        int ac = 7;
        int n1 = ab % ac;
        System.out.println(n1);
        System.out.println(n1 + ac);
    }
}
