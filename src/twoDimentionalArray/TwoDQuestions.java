package twoDimentionalArray;

import java.util.*;

public class TwoDQuestions {

    public static void printRowWiseSum(int[][] ar) {
        int sum = 0;

        for (int i = 0; i < ar.length; i++) {
            sum = 0;
            for (int j = 0; j < ar[i].length; j++) {
                sum += ar[i][j];
            }
            System.out.println(sum);
        }
    }

    public static void printColumnWiseSum(int[][] ar) {
        int sum = 0;

        for (int j = 0; j < ar[j].length; j++) {
            sum = 0;
            for (int i = 0; i < ar.length; i++) {
                sum += ar[i][j];
            }
            System.out.println(sum);
        }
    }

    public static void printDiagonally(int[][] ar) {
// diagonal starting from left to right
        int i = 0;
        int j = 0;
        int n = ar.length;
        while (i < n) {
            System.out.println(ar[i][j]);
            i++;
            j++;
        }
    }

    public static void printAntiDiagonally(int[][] ar) {
// diagonal starting from right to left
        int n = ar.length;
        int i = 0;
        int j = n - 1;
        while (i < n) {
            System.out.println(ar[i][j]);
            i++;
            j--;
        }
    }

    public static void printAllDiagonals(int[][] ar) {
        // print all diagonals starting from oth row
        int n = ar.length;
        int m = ar[0].length;

        for (int k = 0; k < m; k++) {
            int i = 0;
            int j = k;
            while (i < n && j >= 0) {
                System.out.print(ar[i][j] + " ");
                i++;
                j--;
            }
            System.out.println();
        }

        //print the diagonals starting from last column
        for (int k = 1; k < n; k++) {
            int i = k;
            int j = m - 1;
            while (i < n && j >= 0) {
                System.out.print(ar[i][j] + " ");
                i++;
                j--;
            }
            System.out.println();
        }

    }

    public static int[][] showAllDiagonals(int[][] ar) {
        // print all diagonals starting from oth row

        int n = ar.length;
        int m = ar[0].length;
        int[][] ans = new int[n + m - 1][];
        int x = Math.min(n, m);
        int row = 0;

        for (int k = 0; k < m; k++) {
            int i = 0;
            int j = k;
            int idx = 0;
            int[] a = new int[x];

            while (i < n && j >= 0) {
                a[idx] = ar[i][j];
                i++;
                j--;
                idx++;
            }
            ans[row] = a;
            row++;
        }

        //print the diagonals starting from last column
        for (int k = 1; k < n; k++) {
            int i = k;
            int j = m - 1;
            int idx = 0;
            int[] a = new int[x];
            while (i < n && j >= 0) {
                a[idx] = ar[i][j];
                i++;
                j--;
                idx++;
            }
            ans[row] = a;
            row++;
        }
        return ans;
    }

    public static void transposeSquareMatrix(int[][] ar) {
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //swap ar[i][j] with a[j][i]
                int temp = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = temp;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> transposeMatrixUsingArrayList(ArrayList<ArrayList<Integer>> A) {
        //Transpose = i + 1
        int n = A.size();
        int m = A.get(0).size();

        ArrayList<ArrayList<Integer>> transposed = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(A.get(j).get(i));
            }
            transposed.add(row);
        }
        return A;
    }

    public static int[][] transposeRectangleMatrix(int[][] ar) {
        int n = ar.length;
        int m = ar[0].length;
        int[][] tr = new int[m][n];
        int row = 0;

        for (int i = 0; i < n; i++) {
            int[] a = new int[n];
            int idx = 0;
            for (int j = i + 1; j < n; j++) {
                a[idx] = ar[j][i];
                idx++;
            }
            tr[row] = a;
            row++;
        }
        return tr;
    }

    public static void rotateBy90(int[][] ar) {
        // rotate 90 = Take transpose & reverse each row
        int n = ar.length;
        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //swap i,j to j,i
                int temp = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = temp;
            }
        }
        //reverse each row
        for (int i = 0; i < n; i++) {
            reverse(ar[i]);
        }

    }

    public static void rotateBy180(int[][] ar) {
        // rotate 180 = reverse all rows + reverse all columns
        int n = ar.length;
        //reverse all rows
        for (int i = 0; i < n; i++) {
            reverse(ar[i]);
        }

        //reverse each column
        for (int cols = 0; cols < n; cols++) {
            int start = 0;
            int end = n - 1;
            //two pointer
            while (start < end) {
                int temp = ar[start][cols];
                ar[start][cols] = ar[end][cols];
                ar[end][cols] = temp;
                start++;
                end--;
            }
        }
    }

    public static void reverse(int[] a) {
        // two pointer
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    public static void rotateBy270(int[][] ar) {
        // for 270 - reverse row + transpose
        //reverse row
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            reverse(ar[i]);
        }
        //Transpose array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = ar[i][j
                        ];
                ar[i][j] = ar[j][i];
                ar[j][i] = temp;
            }
        }
    }

    public static void rotate90usingArraylist(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        // Take Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i, temp);
            }
        }
        // Reverse Each row
        for (int i = 0; i < n; i++) {
            reverse(A.get(i));
        }
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> ar) {
        int left = 0;
        int right = ar.size() - 1;

        while (left < right) {
            int temp = ar.get(left);
            ar.set(left, ar.get(right));
            ar.set(right, temp);
            left++;
            right--;
        }
        return ar;
    }

    public static void main(String[] args) {
        int[][] n = {
                {10, 2, 7, 3},
                {9, 5, -1, 8},
                {3, 11, 15, 20},
                {13, 111, 115, 120},
                {30, 101, 150, 200}
        };

        int[][] n1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

//        for (int[] row : n1) {
//            for (int element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();

//        printRowWiseSum(n);
//        printColumnWiseSum(n);
//        printDiagonally(n1);
//        System.out.println();
//        printAntiDiagonally(n1);
//        printAllDiagonals(n1);
//        int[][] aa = showAllDiagonals(n1);

//        for(int[] row : aa) {
//            for(int element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println();

//        transposeSquareMatrix(n);
//        int[][] ab = transposeRectangleMatrix(n);
//        rotateBy90(n1);
//        rotateBy180(n1);
//        rotateBy270(n1);
//        for (int[] row : n1) {
//            for (int element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }

//        ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>();
//        Integer[][] nn = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
//
//        for(Integer[] row : nn) {
//            ArrayList<Integer> rowList = new ArrayList<>();
//            for(Integer element : row) {
//                rowList.add(element);
//            }
//            ar.add(rowList);
//        }
//
//        rotate90usingArraylist(ar);
//
//        System.out.println(ar);

        Integer[][] input = {
                {21,62,16,44,55,100,16,86,29},
                {62,72,85,35,14,1,89,15,73},
                {42,44,30,56,25,52,61,23,54},
                {5,35,12,35,55,74,50,50,80},
                {2,65,65,82,26,36,66,60,1},
                {18,1,16,91,42,11,72,97,35},
                {23,57,9,28,13,44,40,47,98}
        };

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(List.of(21, 62, 42, 5, 2, 18, 23)));
        matrix.add(new ArrayList<>(List.of(62, 72, 44, 35, 65, 1, 57)));
        matrix.add(new ArrayList<>(List.of(16, 85, 30, 12, 65, 16, 9)));
        matrix.add(new ArrayList<>(List.of(44, 35, 56, 35, 82, 91, 28)));
        matrix.add(new ArrayList<>(List.of(55, 14, 25, 55, 26, 42, 13)));
        matrix.add(new ArrayList<>(List.of(100, 1, 52, 74, 36, 11, 44)));
        matrix.add(new ArrayList<>(List.of(16, 89, 61, 50, 66, 72, 40)));
        matrix.add(new ArrayList<>(List.of(86, 15, 23, 50, 60, 97, 47)));
        matrix.add(new ArrayList<>(List.of(29, 73, 54, 80, 1, 35, 98)));

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();

        for (Integer[] row : input) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (Integer element : row) {
                rowList.add(element);
            }
            ar.add(rowList);
        }
        System.out.println(ar);

        ArrayList<ArrayList<Integer>> transposed = transposeMatrixUsingArrayList(matrix);

//        output = transposeMatrixUsingArrayList(ar);
        System.out.println(transposed);
    }
}

