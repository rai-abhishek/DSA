package array.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArray {
    ReverseArray() {}

    public int[] usingTwoPointer(int[] arr) {
        int left = 0;
        int right = arr.length -1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public int[] partOfArray(int[] arr,int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    };

    public ArrayList<Integer> usingArrayList(ArrayList<Integer> A, int B, int C) {
        while(B < C) {
            int temp = A.get(B);
            A.set(B,A.get(C));
            A.set(C,temp);
            B++;
            C--;
        }
        return A;
    }

    public void print(int[] arr) {
        int len = arr.length;
        if(len == 0) System.out.println("[]");
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i=0; i < len - 1; i++) {
                sb.append(arr[i]+",");
            }
            System.out.println(sb.append(arr[len -1] +"]"));;
        }

    }

    public static void main(String[] args) {
        ReverseArray r = new ReverseArray();

        int[] num = {1,5,-2,4,6,7,8,9,3};
        Integer[] n = {1,5,-2,4,6,7,8,9,3};

        System.out.println("original: ");
        r.print(num);

        System.out.println("reversed: ");
        int[] scn1 = r.usingTwoPointer(num);
        r.print(scn1);

        System.out.println("reversed part of array with left = 3 & right = 7: ");
        int[] scn2 = r.partOfArray(num,3,7);
        r.print(scn2);

        System.out.println("using ArrayList: ");
        ArrayList<Integer> aa = new ArrayList<>();
        aa.addAll(Arrays.asList(n));
        ArrayList<Integer> res =  r.usingArrayList(aa,3,7);
        System.out.println(res);

    }
}
