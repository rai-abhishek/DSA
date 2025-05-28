package leetCodeTop75;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i <= n - 3; i++) {
            if(nums[i+1] % 2 == 0 && nums[i] + nums[i + 2] == (nums[i + 1] / 2)) {
                count++;
            }
        }
        return count;
    }

    public static int isPrefixOfWord(String st, String b) {
        String[] str = st.split(" ");
        int ans = 0;

        for(int i = 0; i < str.length; i++) {
            String word = str[i];
            int srchLen = b.length();
            int count = 0;
            int j= 0;

            while (j < srchLen && j < word.length() ) {
                if(b.charAt(j) == word.charAt(j)) {
                    count++;
                } else break;
                j++;
            }

            if(count == srchLen && count != 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;

        int i = 0;

        for(int j = i + 1; j < n; j++) {
            if(nums[i] == val && nums[i] != nums[j]) {
                nums[i] = nums[j];
            }
            i++;
        }
        return i + 1;
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int lastElem = digits[n - 1];
        boolean carry = false;

        if(lastElem < 9) {
            digits[n - 1] = lastElem + 1;
        } else {
            digits[n - 1] = 1;
            carry = true;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ans.add(digits[i]);
        }
        ans.add(0);

        int[] fans = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            fans[i] = ans.get(i);
        }
        return fans;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                res.add(nums1[i]);
                i++;
            } else {
                res.add(nums2[j]);
                j++;
            }
        }

        while(j < m) {
            res.add(nums2[j]);
            j++;
        }

        for(int k = 0; k < res.size(); k++) {
            nums1[k] = res.get(k);
        }
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int distance = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(prices[i] < prices[j]) {
                    distance = prices[j] - prices[i];
                    max = Math.max(max,distance);
                }

            }
        }

        return max;
    }




    public static void main(String[] args) {
        int[] n = {7,1,5,3,6,4};

        System.out.println(maxProfit(n));

//        int[] n = {-1,-4,-1,4};
//        System.out.println(countSubarrays(n));

//        String sentence = "hello from the other side", searchWord = "they";
//        System.out.println(isPrefixOfWord(sentence,searchWord));

//        int[] nn = {0,1,2,2,3,0,4,2};
//        int k = 2;
//        System.out.println(removeElement(nn,k));
//
//        for(int i : nn) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

//        int[] aa = {9,9};
//        int[] ans = new int[aa.length + 2];
//        ans = plusOne(aa);
//        for(int i : ans) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

//        int[] a = {1,2,3,0,0,0};
//        int[] b = {2,5,6};
//        int m = 3;
//        int n = 3;
//        merge(a,m,b,n);
//        for(int i : a) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
    }

}
