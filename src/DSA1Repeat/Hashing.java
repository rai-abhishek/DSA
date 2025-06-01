package DSA1Repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Hashing {

    public static void printFrequency(int[] ar) {
        int n = ar.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(ar[i],map.getOrDefault(ar[i],0) + 1);
        }

        for(int key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

    }

    public static boolean hasDuplicates(int[] ar) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : ar) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static int firstUnique(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i : arr) {
            int freq = map.get(i);
            if(freq == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void countCharFreq(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for(char ch : str.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        for(char key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

    }

    public static int[] allDuplicateElem(int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();

        

        for(int i : ar) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for(int freq : map.values()) {
            if(freq > 1) {
                count++;
            }
        }

        int[] ans = new int[count];
        int index = 0;
        for(int key : map.keySet()) {
            if(map.get(key) > 1) {
                ans[index++] = key;
            }
        }

        return ans;
    }

    public static int[] arrayIntersect(int[] ar1, int[] ar2) {
        HashSet<Integer> set1 = new HashSet<>();

        for(int i : ar1) {
            set1.add(i);
        }

        int count = 0;

        for(int i : ar2) {
            if(set1.contains(i)) {
                count++;
            }
        }

        int[] ans = new int[count];
        int index = 0;
        for(int i : ar2) {
            if(set1.contains(i)) {
                ans[index++] = i;
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};
        printFrequency(arr);

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Has duplicates: " + hasDuplicates(arr2));

        int[] arr3 = {1, 2, 3, 2};
        System.out.println("Has duplicates: " + hasDuplicates(arr3));

        int[] arr4 = {1, 2, 3, 2,1,3,4};
        System.out.println("first unique: " + firstUnique(arr4));

        String st = "Hellohh World";

        countCharFreq(st);

        int[] arr5 = {4, 5, 9, 4, 9, 2, 3, 5};

        System.out.println("All duplicate element ");
        int[] op =  allDuplicateElem(arr5);
        for(int i : op) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] in1 = {1, 2, 3,10,10, 4, 5};
        int[] in2 = {3, 5, 7, 9};
        int[] a = arrayIntersect(in1, in2);
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
