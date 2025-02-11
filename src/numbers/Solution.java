package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[][] shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ans = new int[row][col];
        int idx = 0;
        k = k % (row * col);

        for(int i = 0; i < row;i++) {
            int[] eachRow = new int[col];
            for(int j = 0; j < col; j++) {
                eachRow[j] = grid[i][j + k];
            }
            ans[idx] = eachRow;
            idx++;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] n = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("-----Input-----");
        for(int[] row: n) {
            for(int col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        int[][] ans = new int[3][3];
        ans = shiftGrid(n,1);

        System.out.println("-----Output-----");
        for(int[] row: ans) {
            for(int col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}


