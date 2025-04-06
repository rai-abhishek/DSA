package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    /**
     * Search an element K. If the K is present return its index otherwise return -1.
     */

    public static int searchElementUsingBinarySearch(int[] ar, int k) {
        int n = ar.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] == k) {
                return mid;
            } else if (ar[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Given a sorted array. Find first occurrence of K.
     */
    public static int findFirstOccurrence(int[] ar, int k) {
        int n = ar.length;
        int l = 0, r = n - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] == k) {
                ans = mid;
                r = mid - 1;
            } else if (ar[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int findLastOccurrence(int[] ar, int k) {
        int n = ar.length;
        int l = 0, r = n - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] == k) {
                ans = mid;
                l = mid + 1;
            } else if (ar[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int findElementFrequency(int[] ar, int k) {
        int count = 0, n = ar.length;
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (ar[i] == k) {
                count++;
            }
        }
        return count;
    }

    public static int findElementFrequencyBinarySearch(int[] ar, int k) {
        int n = ar.length;
        // find first occurrence
        int l = 0, r = n - 1, leftIdx = 0, rightIdx = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] == k) {
                leftIdx = mid;
                r = mid - 1;
            } else if (ar[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        //find last occurrence
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] == k) {
                rightIdx = mid;
                l = mid + 1;
            } else if (ar[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return rightIdx - leftIdx + 1;
    }

    /**
     * Given array. Find any local Minima.
     */

    public static int findLocalMinima(int[] ar) {
        int n = ar.length;
        if (n == 1) {
            return ar[0];
        } else if (ar[0] <= ar[1]) {
            return ar[0];
        } else if (ar[n - 1] <= ar[n - 2]) {
            return ar[n - 1];
        }

        int l = 1, r = n - 2;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] <= ar[mid - 1] && ar[mid] <= ar[mid + 1]) {
                return ar[mid];
            } else if (ar[mid - 1] <= ar[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int sqrtBF(int a) {
        int i = 1, ans = 1;
        while (i * i <= a) {
            ans = i;
            i++;
        }
        return ans;
    }

    public static int sqrtBinarySearch(int a) {
        int l = 1, r = a, ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid * mid <= a) {
                ans = mid;
                l = mid + 1;
            } else if (mid * mid > a) {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (n == 1) {
            res.add(0);
            res.add(0);
            return res;
        }

        res.add(leftMost(A, B));
        res.add(rightMost(A, B));
        return res;
    }

    public static int leftMost(List<Integer> A, int B) {
        int n = A.size();
        int left = -1;
        // find left most element
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (A.get(mid) == B) {
                left = mid;
                r = mid - 1;
            } else if (A.get(mid) > B) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return left;
    }

    public static int rightMost(List<Integer> A, int B) {
        int n = A.size();
        int right = -1;
        // find left most element
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (A.get(mid) == B) {
                right = mid;
                l = mid + 1;
            } else if (A.get(mid) > B) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return right;
    }

    public static int searchInsert(ArrayList<Integer> A, int B) {
        int n = A.size();
        int l = 0, r = n - 1, ans = -1, tempAns = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (A.get(mid) == B) {
                ans = mid;
                return ans;
            } else if (A.get(mid) > B) {
                r = mid - 1;
                tempAns = mid;
            } else {
                l = mid + 1;
                tempAns = mid;
            }
        }

        if (tempAns == A.size() - 1) {
            return tempAns + 1;
        } else if (ans == -1) {
            return tempAns;
        } else return ans;

    }

    public static int singleElement(ArrayList<Integer> A) {
        int n = A.size();

        //edge cases
        if (n == 1) {
            return A.get(0);
        }

        if (!A.get(0).equals(A.get(1))) {
            return A.get(0);
        }

        if (!A.get(n - 1).equals(A.get(n - 2))) {
            return A.get(n - 1);
        }

        int l = 1, r = n - 2;

        while (l < r) {
            int mid = (l + r) / 2;

            // if element is unique, return it
            if (!A.get(mid).equals(A.get(mid - 1)) && !A.get(mid).equals(A.get(mid + 1))) {
                return A.get(mid);
            }

            //if the current element is equal to previous element, then move to prev element
            int fo = mid;
            if (A.get(mid).equals(A.get(mid - 1))) {
                fo--;
            }

            if (fo % 2 == 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return -1;
    }

    public static int painterPartition(int[] ar, int p) {
        /**
         * <h4>Search space -</h4>
         *      Max possible time - sum of all array elements
         *      Min possible time - max element of the array
         * <h4>Target -</h4>
         *      Min time to paint all Board with p painter
         * <h4>condition -</h4>
         *      Is it possible to finish work within time = mid if p painters are available
         *      if Yes - then go to left side (r = mid - 1)
         *      if No - then go to right side (l = mid + 1)
         */

        // create search space
        int max = ar[0];
        int sum = ar[0];

        for (int i = 1; i < ar.length; i++) {
            max = Math.max(ar[i], max);
            sum += ar[i];
        }

        int l = max, r = sum, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            boolean flag = isPaintingPossible(ar, p, mid);
            if (flag) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPaintingPossible(int[] ar, int p, int T) {
        int timeLeft = T;
        int painters = 1;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] <= timeLeft) {
                timeLeft -= ar[i];
            } else {
                painters++;
                timeLeft = T - ar[i];
            }
        }

        if (painters <= p) {
            return true;
        } else {
            return false;
        }
    }

    public static int aggressiveCows(int[] ar, int m) {
        /**
         * <h4>Search Space</h4>
         *      min possible distance - min distance between two elements in array
         *      max possible distance - last minus first element in array
         * <h4>target - </h4>
         *      Maximise the min distance between any pair of cows
         * <h4>Condition</h4>
         *     By maintaining at least distance = mid, is it possible to place M cows in N stalls
         *     if Yes - ans = mid and move right side (l = mid + 1)
         *     if No - move left side (r = mid - 1)
         */

        int n = ar.length;
        int r = ar[n - 1] - ar[0];
        int l = ar[n - 1] - ar[0];

        for (int i = 0; i < n - 1; i++) {
            l = Math.min(l, ar[i + 1] - ar[i]);
        }

        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            boolean flag = isCowsPlacementPossible(ar, m, mid);

            if (flag) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isCowsPlacementPossible(int[] ar, int m, int dist) {
        int lastPos = ar[0];
        int cowPlaced = 1;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] - lastPos >= dist) {
                cowPlaced++;
                lastPos = ar[i];
            }
        }
        if (cowPlaced >= m) {
            return true;
        } else {
            return false;
        }
    }

    public static int aggressiveCowsArrayList(ArrayList<Integer> A, int B) {
        /**
         * <h4>Search Space</h4>
         *      min possible distance - min distance between two elements in array
         *      max possible distance - last minus first element in array
         * <h4>target - </h4>
         *      Maximise the min distance between any pair of cows
         * <h4>Condition</h4>
         *     By maintaining at least distance = mid, is it possible to place M cows in N stalls
         *     if Yes - ans = mid and move right side (l = mid + 1)
         *     if No - move left side (r = mid - 1)
         */

        // Search space = {min distance, max distance}
        int n = A.size();
        int r = A.get(n - 1) - A.get(0);
        int l = A.get(n - 1) - A.get(0);
        int ans = -1;

        for(int i = 0; i < n - 1; i++) {
            l = Math.min(l, A.get(i+ 1) - A.get(i));
        }

        while(l <= r) {
            int mid = (l + r) / 2;

            boolean flag = isCowsPlacementPossibleArrayList(A, B, mid);
            if(flag) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isCowsPlacementPossibleArrayList(ArrayList<Integer> A, int B, int dist) {
        int lastPost = A.get(0);
        int cowsplaced = 1;
        for(int i = 1; i < A.size();i++) {
            if(Math.abs(A.get(i) - lastPost) >= dist) {
                cowsplaced++;
                lastPost = A.get(i);
            }
        }
        if(cowsplaced >= B) {
            return true;
        } else return false;
    }

    public static int minPagesBooks(ArrayList<Integer> A, int B) {
        //search space -
        // min possible pages - min element of the array
        // max possible pages - sum of all the elements of the array
        // Target - min pages
        //conditions -
        // Is it possible to minimize number of pages = mid
        // If yes then go left (r = mid - 1)
        // if no then go right (l = mid + 1)

        int n = A.size();
        int min = A.get(0);
        int sum = A.get(0);
        int ans = -1;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, A.get(i));
            sum += A.get(i);
        }

        int l = min, r = sum;

        while (l <= r) {
            int mid = (l + r) / 2;

            boolean flag = isMinBooksPossible(A, B, mid);
            if (flag) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isMinBooksPossible(ArrayList<Integer> A, int B, int pages) {
        int lastBook = A.get(0);
        int booksPlaced = 1;

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) - lastBook >= pages) {
                booksPlaced++;
                lastBook = A.get(i);
            }
        }

        if (booksPlaced >= B) {
            return true;
        } else {
            return false;
        }
    }

    public static int searchSortedAndRotatedArray(int[] ar, int k) {
        int n = ar.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (ar[mid] == k) {
                return mid;
            } else if (ar[mid] >= ar[0] && k < ar[0]) {
                l = mid + 1;
            } else if (ar[mid] < ar[0] && k >= ar[0]) {
                r = mid - 1;
            } else {
                if (ar[mid] > k) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int arrayMedianUsingMergeSort(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        int[] c = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while(i < n1 && j < n2) {
            if(a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while(i < n1) {
            c[k++] = a[i++];
        }

        while(j < n2) {
            c[k++] = b[j++];
        }

        int n3 = c.length;
        if(n3 % 2 == 1) {
            return (c[n3 / 2]);
        } else {
            return (int)((c[n3 / 2] + c[n3/ 2 - 1]) / 2.0);
        }
    }


    public static void main(String[] args) {
//        int[] a = {3,6,9,12,14,19,20,23,25,27};
//        int b = 14;
//        System.out.println(searchElementUsingBinarySearch(a,b));
//
//        int[] c = {-5,-5,-3,0,0,1,5,5,5,5,5,5,8,10,10,15};
//        int d = 5;
//        System.out.println(findFirstOccurrence(c,d));
//        System.out.println(findLastOccurrence(c,d));
//        System.out.println(findElementFrequency(c,d));
//
//        System.out.println(findElementFrequencyBinarySearch(c,d));
//
//        int[] e = {7,6,1,0,-1,9,15,17};
//        System.out.println(findLocalMinima(e));
//
//        int f = 50;
//        System.out.println(sqrtBF(f));
//        System.out.println(sqrtBinarySearch(f));
//
//        List<Integer> A = Arrays.asList(
//                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
//                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
//                4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
//                5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
//                6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
//                7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
//                8, 8, 8, 8, 8, 8, 8, 8,
//                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
//                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10
//        );
//        int B = 10;
//        System.out.println(searchRange(A,B));
        ArrayList<Integer> G = new ArrayList<>();
//            G.addAll(Arrays.asList(17, 30, 32, 69, 94, 96, 106, 118, 127, 159, 169, 170, 178, 183, 209, 238, 242, 247, 253, 261,
//                    265, 279, 288, 302, 305, 316, 352, 357, 374, 376, 392, 402, 410, 421, 439, 442, 444, 446, 454, 458, 464, 467,
//                    468, 498, 500, 513, 523, 541, 545, 556, 575, 608, 616, 629, 631, 635, 669, 674, 682, 686, 693, 695, 719, 733, 754,
//                    755, 756, 778, 802, 822, 824, 828, 835, 847, 848, 862, 864, 878, 883, 885, 904, 908, 928, 934));
//        int H = 104;
//        System.out.println(searchInsert(G,H));

//        G.addAll(Arrays.asList(13,13,21,21,27,50,50,102,102,108,108,110,110,117,117,120,120,123,123,124,124,132,132,
//                164,164,166,166,190,190,200,200,212,212,217,217,225,225,238,238,261,261,276,276,347,347,348,348,
//                386,386,394,394,405,405,426,426,435,435,474,474,493,493));
//        G.addAll(Arrays.asList(8, 8, 5, 5, 6, 2, 2));
//        System.out.println(singleElement(G));

//       int[] xx = {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};
//       int k = 4;
//        System.out.println(painterPartition(xx,k));
//
//        int[] xy = {5,17,100,11};
//        int m = 2;
//        System.out.println(aggressiveCows(xy,m));

        G.addAll(Arrays.asList(5,17,100,11));
        int B = 2;
        System.out.println(aggressiveCowsArrayList(G,B));


//        ArrayList<Integer> aa = new ArrayList<>();
//        aa.addAll(Arrays.asList(12,34,67,90));
//        int ab = 2;
//        System.out.println(minPagesBooks(aa,2));

//        int[] q = {30, 40, 50, 60, 70, 80, 10, 20, 25, 28};
//        int qq = 25;
//        System.out.println(searchSortedAndRotatedArray(q, qq));
          int[] aq = {7,12,14,15};
          int[] bq = {1,2,3,4,9,11};

//        System.out.println(arrayMedianUsingMergeSort(aq,bq));

    }
}
