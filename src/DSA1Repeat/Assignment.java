package DSA1Repeat;

import java.util.ArrayList;
import java.util.List;


public class Assignment {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return ans;

        int i = 0, j = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int top = n;
        int bottom = m;

        while (top > 1 && bottom > 1) {
            for (int k = 0; k < m; k++) {
                ans.add(matrix[i][j]);
                j++;
            }

            for (int k = 0; k < bottom - 1; k++) {
                ans.add(matrix[i][j]);
                i++;
            }

            for (int k = 0; k < m; k++) {
                ans.add(matrix[i][j]);
                j--;
            }

            for (int k = 0; k < n; k++) {
                ans.add(matrix[i][j]);
                i--;
            }

            top = top - 2;
            bottom = bottom - 2;
            i++;
            j++;
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int row = 0, col = 0, num = 1;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (A > 1) {
            for (int i = 0; i < A; i++) {
                result.get(row).set(col, num);
                col++;
            }

            for (int i = 0; i < A; i++) {
                result.get(row).set(col, num);
                row++;
            }

            for (int i = 0; i < A; i++) {
                result.get(row).set(col, num);
                col--;
            }

            for (int i = 0; i < A; i++) {
                result.get(row).set(col, num);
                row--;
            }

            A = A - 2;
            row++; col++;
        }

        return result;
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();

        if(n == 1) return A;

        int idx = 0;

        if(n == 2) {
            int temp = A.get(0);
            A.set(0,A.get(1));
            A.set(1,temp);
            return A;
        }

        for(int i = n - 1; i > 0 ; i--) {
            if(A.get(i - 1) < A.get(i)) {
                idx = i - 1;
                break;
            }
        }

        if(idx >= 0) {
            for(int i = n - 1; i > idx; i--) {
                if(A.get(i) > A.get(idx)) {
                    int temp = A.get(i);
                    A.set(i,A.get(idx));
                    A.set(idx,temp);
                    break;
                }
            }
            reverse(A,idx + 1, n - 1);
        }

        return A;
    }


    private static void reverse(ArrayList<Integer> A, int i , int j) {
        while(i < j) {
            int temp = A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        List<Integer> l = new ArrayList<>();
//
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//
////       l = spiralOrder(matrix);
//        ans = generateMatrix(5);
//
//        for (ArrayList<Integer> i : ans) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
////        System.out.println(l);
        Integer[] a = {769, 533};

        int[] res = new int[a.length];

        ArrayList<Integer> b = new ArrayList<>();
        for(Integer i : a) {
            b.add(i);
        }

        ArrayList<Integer> c = new ArrayList<>();

        c = nextPermutation(b);

        for(int i : c) {
            System.out.print(i + " ");
        }
        System.out.println();


    }
}
