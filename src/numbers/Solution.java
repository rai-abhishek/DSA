package numbers;

import trees.BinaryTree;
import trees.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
        public static ArrayList<Integer> flip(String A) {
            int n = A.length();
            //BF
            ArrayList<Integer> ans = new ArrayList<Integer>();
            for(int i = 0; i < n;i++) {
                for(int j = i ; j < n;j++) {
                    for(int k = i; k < j;k++) {
                        char ss= A.charAt(k);
                        System.out.println(ss);
//                        if(ss == '1') {
//                            ss[k] = '0';
//                        } else {
//                            ss[k] = '1';
//                        }
                    }
                }
            }
            return ans;
        }


    public static void main(String[] args) {
        String s = "101";
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans = flip(s);


    }
}

