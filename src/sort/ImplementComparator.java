package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ImplementComparator {
    private static int countFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static Integer[] largestNumber(Integer[] ar) {
        Arrays.sort(ar, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String ab = a + "" + b;
                String ba = b + "" + a;

                int i = 0, j = 0;

                while (i < ab.length() && j < ba.length()) {
                    if (ab.charAt(i) < ba.charAt(i)) {
                        return 1;
                    } else if (ab.charAt(i) > ba.charAt(i)) {
                        return -1;
                    }
                    i++;
                    j++;
                }
                return 0;
            }
        });

        return ar;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 30, 34, 5, 9};
        largestNumber(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] ar = {9, 3, 10, 6, 4};
        Arrays.sort(ar, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int factorA = countFactors(o1);
                int factorB = countFactors(o2);

                if (factorA < factorB) {
                    return -1;
                } else if (factorA > factorB) {
                    return 1;
                } else {
                    return o1 - o2;
                }
            }
        });

        System.out.println(Arrays.toString(ar));


        // int[] to Integer[] conversion
        int[] ar1 = {9, 3, 10, 6, 4};
//        Integer[] arrObj = Arrays.stream(ar1).boxed().toArray(Integer[]:: new);

        //regular
        Integer[] arrObj = new Integer[ar1.length];
        for (int i = 0; i < ar1.length; i++) {
            arrObj[i] = ar1[i];
        }

        Arrays.sort(arrObj, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int factorA = countFactors(o1);
                int factorB = countFactors(o2);

                if (factorA < factorB) {
                    return -1;
                } else if (factorA > factorB) {
                    return 1;
                } else {
                    return o1 - o2;
                }
            }
        });

//        ar1 = Arrays.stream(arrObj).mapToInt(Integer::intValue).toArray();
        //regular
        for (int i = 0; i < arrObj.length; i++) {
            ar1[i] = arrObj[i];
        }

        System.out.println(Arrays.toString(ar1));

        Integer[] x = {3, 4, 5, 2, 1, 7, 8, 5, 6,9};
        ArrayList<Integer> r = new ArrayList<>();
        r.addAll(Arrays.asList(x));
//        
//
        Collections.sort(r, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        StringBuilder s = new StringBuilder();
        for(int num : r) {
            s.append(num);
        }
        System.out.println(s.toString());

        Integer[] g = {1,8,3,4,5,9};
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(Arrays.asList(g));
    }
}
