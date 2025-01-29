package array.carryForward;

import java.util.ArrayList;
import java.util.Arrays;

public class LeaderElement {
    public static ArrayList<Integer> leaderElement(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = A.size();
        int max = A.get(n -1);
        ans.add(max);

        for (int i = n - 2; i > 0; i--) {
            if(A.get(i) > A.get(i+1) && A.get(i) > max) {
                max = A.get(i);
                ans.add(A.get(i));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Integer[] n = {93,57,83,41,100,10,79,27,94,22,4,96,48,18,89,37,21,5,46,81,15,30,47,23,34,65,55,9,36,20,54,17,7,56,78,84,87,97,16,69,28,11,44,49,8,25,98,75,53,62,19,24,80,68,50,91,1,86,77,14,72,66,42,63,73,45,31,61,85,64,35,32,92,71,74,3,99,52,90,43,6,40,38,2,12,59,29,82,76,60,67,13,70,58,39,33,95,88,51,26};
        a.addAll(Arrays.asList(n));

        System.out.println(leaderElement(a));
    }
}
