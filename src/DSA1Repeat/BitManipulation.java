package DSA1Repeat;

import java.util.ArrayList;
import java.util.Arrays;

public class BitManipulation {
    public static String[] checkBit(int N) {
        String[] s = new String[32];

        for(int i = 0; i < 32;i++) {
            if((N & (1 << i)) != 0) {
                s[31 - i] = "1";
            } else {
                s[31 - i] = "0";
            }
        }

        return s;
    }

    public static int[] singleNumber(int[] ar) {
        // find XOR
        int xor = 0;
        int n = ar.length;
        for(int i = 0; i < n; i++) {
            xor = xor ^ ar[i];
        }

        // find the set bit in XOR
        int i = 0;
        while(i < 32) {
            if((xor&(1<<i)) != 0) {
                break;
            }
            i++;
        }

        //create two groups based on set bit & take XOR within each group
        int set = 0, unset = 0;
        for(int j = 0; j < n;j++) {
            if((ar[j]&(1<<i)) != 0) {
                set = set ^ ar[j];
            } else {
                unset = unset ^ ar[j];
            }
        }

        //return two numbers from each group
        int[] ans = new int[2];
        ans[0] = set;
        ans[1] = unset;
        return ans;
    }

    public static int magicNumber(int A) {
        int ans = 0;

        for(int i = 0; i < 32; i++) {
            if((A & (1 << i)) != 0) {
                ans += Math.pow(5,i + 1);
            }
        }

        return ans;
    }

    public static Long solve(Long A, int B) {
        for(int i = 0; i < B; i++) {
            if((A & (1 << i)) != 0) {
                A = A ^ (1 << i);
            }
        }
        return A;
    }

    public static int findMinXor(ArrayList<Integer> A) {
        int n = A.size();
        int min = A.get(0) ^ A.get(1);

        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int xor = A.get(i) ^ A.get(j);
                min = Math.min(xor, min);
            }
        }

        return min;
    }

    public static int[] findXOR(ArrayList<Integer> A) {
        int[] ans = new int[A.size()];

        for(int i = 0; i < A.size() - 1; i++) {
            ans[i] = A.get(i) ^ A.get(i + 1);
        }

        return ans;
    }

    public static int solve(int A) {
        return fib(A);
    }

    public static int fib(int A) {
        if(A == 0) return 1;

        return fib(A - 1) * fib(A);
    }


    public static void main(String[] args) {
//        String[] a = new String[32];
//
//        a = checkBit(10);
//        for(String i : a) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        int[] b = {4,5,4,9,10,10,5,13};
//        int[] res = new int[2];
//        res = singleNumber(b);
//        for(int i : res) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        int A = 3;
//        System.out.println(magicNumber(A));
//
//        long B = 93;
//        int C = 4;
//        System.out.println(solve(B, C));

//        Integer[] D = {2,13,7,9,3};
//        ArrayList<Integer> ar = new ArrayList<>();
//        ar.addAll(Arrays.asList(D));
//
////        System.out.println(findMinXor(ar));
//
//        int[] res = new int[ar.size()];
//        res = findXOR(ar);
//
//        for(int i : res) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        solve(5);
    }

}
