package DSA1Repeat;

import java.util.ArrayList;
import java.util.Arrays;

public class Lecture2 {
    public static int findFirstMissingNaturalNumbersBF(int[] ar) {
        int n = ar.length;
        int nn = 1;

        //update -ve numbers
        for(int i = 0; i < n; i++) {
            if(ar[i] < 0) {
                ar[i] = 0;
            }
        }

        Arrays.sort(ar);

        for(int i = 0; i < n;i++) {
            if(ar[i] != 0) {
                if(ar[i] != nn) {
                    return nn;
                }
                nn++;
            }
        }
        return n + 1;
    }
    public static int findFirstMissingNaturalNumbers(int[] ar) {
        int n = ar.length;
        int nn = 1;

        // update -ve number to n + 2; out or range.
        for(int i = 0; i < n;i++) {
            if(ar[i] < 0) {
                ar[i] = n + 2;
            }
        }

        //approach
        // for each element (absolute),
        // if it is in range
        //      get the index
        //      at the index make the value -ve
        for(int i = 0; i < n;i++) {
            int elem = Math.abs(ar[i]);

            if(elem >= 1 && elem <=n) {
                int idx = elem - 1;
                if(ar[idx] > 0) {
                    ar[idx] *= -1;
                }
            }
        }

        //return the index + 1 for the positive number
        for(int i = 0; i < n; i++) {
            if(ar[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();

        int i = 0, j = m - 1;

        while(i < n && j >= 0) {
            int elem = A.get(i).get(j);
            if(elem == B) {
                return ((i + 1) * 1009 + (j + 1));
            } else if(elem > B) {
                j--; // left
            } else {
                i++; //down
            }
        }
        return -1;
    }

    public static int max1Row(ArrayList<ArrayList<Integer>> A) {
        int max = 0;
        int n = A.size();
        int m = A.get(0).size();
        int[] res = new int[n];

        for(int i = 0 ; i < n; i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                if(A.get(i).get(j) == 1) {
                    count++;
                }
            }
            res[i] = count;
        }

        int ans = 0;
        for(int i = 0; i < n;i++) {
            if(res[i] > max) {
                max = res[i];
                ans = i;

            }
        }
        return ans;
    }

    public static int minSwaps(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;

        for(int i = 0; i < n;i++) {
            int elem = A.get(i);

            if(elem > B) {
                for(int j = i + 1; j < n; j++) {
                    int smElem = A.get(j);
                    if(smElem< B) {
                        count++;
                        System.out.println(smElem + "_" + elem + "_" + count);
                        swap(A,i,j);
                        break;
                    }
                }

            }
        }
        return count;
    }

    public static void swap(ArrayList<Integer> A,int i ,int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j,temp);
    }


    public static void main(String[] args) {
        int[] a = {5,3,1,-1,-2,-4,7,2};

        int[] c = {2,3,1,2};

//        System.out.println(findFirstMissingNaturalNumbersBF(a));
//        System.out.println(findFirstMissingNaturalNumbers(c));
        Integer[][] d = {
                {0,0,1,1,1},
                {0,0,0,1,1},
                {0,0,0,1,1},
                {0,0,0,0,1},
                {0,0,0,1,1}
        };

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (Integer[] row : d) {
            list.add(new ArrayList<>(Arrays.asList(row)));
        }

//        System.out.println(max1Row(list));

        ArrayList<Integer> l = new ArrayList<>();
        Integer[] e = {52,7,93,47,68,26,51,44,5,41,88,19,78,38,17,13,24,74,92,5,84,27,48,49,37,59,3,56,79,26,55,60,16,83,63,40,55,9,96,29,7,22,27,74,78,38,11,65,29,52,36,21,94,46,52,47,87,33,87,70};

        l.addAll(Arrays.asList(e));

        System.out.println(minSwaps(l,19));


    }
}
