package interviewQ.intermediate;

import java.util.zip.ZipError;

public class IntrmdtQ {
    /** <h1>Max Consecutive Ones after replacement</h1>
     * Given a binary array[]. We can atmost replace a single 0 with 1. Find the maximum consecutive 1's we can get in
     * the array[] after the replacement.
     * example - A = [1 1 0 1 1 0 1 1 1]
     * Idea - Count LHS & RHS 1's and add 1 to it.
     */

    public static int findMaxConsecutiveOnesByReplace(int[] a) {
        int countOnes = 0;
        int n = a.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] == 1) countOnes++;
        }

        // Boundry case
        // all 1's in array
        if(countOnes == n) return n;

        //all zeros in array
        if(countOnes == 0) return 1;

        for(int i = 0; i < n;i++) {
            if(a[i] == 0) {
                // count LHS ones
                int l = 0;
                int r = 0;
                for(int j = i -1; j > 0; j--) {
                    if(a[j] == 1) {
                        l++;
                    } else break;
                }
                //count RHS ones
                for(int j = i + 1; j < n; j++) {
                    if(a[j] == 1) {
                        r++;
                    } else break;
                }
                ans = Math.max(ans,l + r + 1);
            }
        }
        return ans;
    }

    /** <h1>Max Consecutive Ones after swap</h1>
     * Given a binary array[]. We can swap a single 0 with 1. Find the maximum consecutive 1's we can get in
     * the array[] after atmost 1 swap.
     * example - A = [1 1 0 1 1 0 1 1 1]
     * Idea - Count LHS & RHS 1's and add 1 to it. But since replacement is happening, if there is no 1 to replace then
     * the max length will be l + r.
     */
    public static int findMaxConsecutiveOnesBySwap(int[] a) {
        int countOnes = 0;
        int n = a.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] == 1) countOnes++;
        }

        // Boundry case
        // all 1's in array
        if(countOnes == n) return n;

        //all zeros in array
        if(countOnes == 0) return 0;

        for(int i = 0; i < n;i++) {
            if(a[i] == 0) {
                // count LHS ones
                int l = 0;
                int r = 0;
                for(int j = i -1; j > 0; j--) {
                    if(a[j] == 1) {
                        l++;
                    } else break;
                }
                //count RHS ones
                for(int j = i + 1; j < n; j++) {
                    if(a[j] == 1) {
                        r++;
                    } else break;
                }
                if( l + r == countOnes) {
                    ans = Math.max(ans,l + r);
                } else {
                    ans = Math.max(ans,l + r + 1);
                }

            }
        }
        return ans;
    }

    /** <h1>Majority Element</h1>
     *  Given an array n, find the majority element. Majority element is the one which occurs more than n/2 times.
     *  example - A = [3,4,3,6,1,3,2,5,3,3,3] ans = 3
     */

    public static int majorityElement(int[] a) {
        int majority = a[0];
        int freq = 1;
        int n = a.length;

        for(int i = 1; i < n;i++){
            if(freq == 0) {
                majority = a[i];
                freq++;
            } else if(a[i] == majority) {
                freq++;
            } else {
                freq--;
            }
        }
        return majority;
    }

    /** <h1>Make Row and column zero in 2D array if element is zero</h1>
     * given elements are positive
     * Idea - since all the elements are positive, first multiply the row & col by -1 where zero is found.
     * Later update all negatives to zero.
     */

    public static int[][] makeRowColumnZeros(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < n; i++) {
            boolean zeroFlag = false;
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    zeroFlag = true;
                    break;
                }
            }
            if(zeroFlag) {
                for(int j = 0; j < m;j++) {
                    if(arr[i][j] > 0) {
                        arr[i][j] *= -1;
                    }
                }
            }
        }

        for(int j = 0; j < m; j++) {
            boolean zeroFlag = false;
            for (int i = 0; i < n; i++) {
                if(arr[i][j] == 0) {
                    zeroFlag = true;
                    break;
                }
            }
            if(zeroFlag) {
                for(int i = 0; i < n;i++) {
                    if(arr[i][j] > 0) {
                        arr[i][j] *= -1;
                    }
                }
            }
        }

        for(int i =0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] < 0) {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] n = {1,1,0,1,1,0,1,1,1};
        int[] n1 = {1,1,1,0,1,1,0,1,0,0,1,0,1,0,0,0,0,0,0,1,1,0,1,0,0,1,1,0,0,1,0,0,0,1,0,0,1,0,1,1,1,0,0,10,0,0,0,0,1,0};
        System.out.println(findMaxConsecutiveOnesByReplace(n));
        System.out.println(findMaxConsecutiveOnesBySwap(n1));

        System.out.println("----- Majority Element -----");
        int[] A = {3,4,3,6,1,3,2,5,3,3,3};
        System.out.println(majorityElement(A));

        System.out.println("----- 2D Array make element zeros -----");
        int[][] ar = {
                {1,2,3, 4},
                {5,6,7, 0},
                {9,10,0,12}
        };

        int[][] ar1 = {
                {1,2,3,4},
                {5,6,7,0},
                {9,10,11,12}
        };


        for(int[] row : ar1) {
            for(int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] ans = makeRowColumnZeros(ar1);
        for(int[] row : ans) {
            for(int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
