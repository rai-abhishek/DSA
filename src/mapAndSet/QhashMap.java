package mapAndSet;

import java.util.*;

public class QhashMap {
    public static int[] frequencyBF(int[] ar, int[] q) {
        int[] ans = new int[q.length];
        for(int i = 0; i < q.length;i++) {
            int count = 0;
           for(int j = 0; j < ar.length; j++) {
               if(ar[j] == q[i]) {
                   count++;
               }
           }
           ans[i] = count;
        }
        return ans;
    }

    public static int[] fMap(Integer[] ar, Integer[] q) {
        HashMap<Integer, Integer> fmap = new HashMap<>();

        //fill map
        // if key not found, add the freq else update it
        for(int i = 0; i < ar.length;i++) {
            if(fmap.containsKey(ar[i]) == false) {
                fmap.put(ar[i],1);
            } else {
                int val = fmap.get(ar[i]);
                fmap.computeIfPresent(ar[i],(k,v) -> v + 1);
            }
        }

        int[] ans = new int[q.length];
        for(int i = 0; i < q.length;i++) {
            int elem = q[i];

            if(fmap.containsKey(elem) == true) {
                ans[i] = fmap.get(elem);
            }
        }
        return ans;
    }

    public static int countDistinctElem(int[] ar) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < ar.length;i++) {
            set.add(ar[i]);
        }
        return set.size();
    }


    public static int longestSubstringWithoutRepeat(String s) {
        //for each character, put the value in set and check if the new char is already present, then remove all the pre
        // -vious character from set.
        HashSet<Character> charSet = new HashSet<>();
        int maxLength = 0, j = 0;
        for(int i = 0; i < s.length();i++) {
            char elem = s.charAt(i);
            if(charSet.contains(elem) == true) {
                while(s.charAt(j) != elem) {
                    charSet.remove(s.charAt(j));
                    j++;
                }
                charSet.remove((s.charAt(j)));
                j++;
            }
            charSet.add(elem);
            maxLength = Math.max(maxLength,i - j + 1);
        }
        return maxLength;
    }

    public static int firstNonRepeatingElem(int[] ar) {
        //create a frequency map
        HashMap<Integer, Integer> map = new HashMap<>();

//        logic wise
//        for(int i = 0; i < ar.length;i++) {
//            if(map.containsKey(ar[i]) == false) {
//                map.put(ar[i], 1);
//            } else {
//                map.computeIfPresent(ar[i], (k,v) -> v + 1);
//            }
//        }

//        easy way
        for(int num : ar) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // check the map
        for(int i = 0; i < ar.length; i ++) {
            if(map.get(ar[i]) == 1) {
                return ar[i];
            }
        }
        return -1;
    }

    public static int firstNonRepeatingElemArrayList(ArrayList<Integer> A) {

        // create freq map
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0;i < A.size();i++) {
            int val = A.get(i);
            map.put(val,map.getOrDefault(val,0) + 1);
        }

        System.out.println(map);

        //check for 1 in map
        for(int i = 0; i < A.size();i++) {
            if(map.get(A.get(i)) > 1) {
                return A.get(i);
            }
        }
        return -1;
    }

    /**
     * exist a pair i,j such that val(i) + val(j) = k & i != j
     * use HashSet on the go
     */

    public static boolean pairExistsSet(int[] ar, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < ar.length;i++) {
            if(set.contains(k - ar[i])) {
                return true;
            }
            set.add(ar[i]);
        }
        return false;
    }

    public static int pairExistsHashMap(int[] ar, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < ar.length;i++) {
            //search = true, then the count of element in array = freq of map
            int elem = k - ar[i];
            if(map.containsKey(elem)) {
                ans += map.get(elem);
            }

            // if not found then add the element and exit else increment the frequency
            if(!map.containsKey(ar[i])) {
                map.put(ar[i], 1);
            } else {
                int val = map.get(ar[i]);
                map.put(ar[i],val + 1);
            }
        }
        return ans;
    }

    public static boolean subArraySumEqualZero(int[] ar) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;

        for(int i = 0 ; i < ar.length;i++) {
            sum += ar[i];
            if(set.contains(ar[i])) {
                return true;
            }
            set.add(ar[i]);
        }
        return false;
    }

    public static boolean subArraySumEqualsK(int[] ar,int k) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;

        for(int i = 0 ; i < ar.length;i++) {
            sum += ar[i];
            if(set.contains(k - ar[i])) {
                return true;
            }
            set.add(ar[i]);
        }
        return false;
    }

    public static int subArraySumEqualsKUsingMap(int[] ar,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < ar.length;i++) {
            int elem = k - ar[i];
            if(map.containsKey(elem)) {
                ans += map.get(elem);
            }

            if(!map.containsKey(ar[i])) {
                map.put(ar[i], 1);
            } else {
                int val = map.get(ar[i]);
                map.put(ar[i], val + 1);
//                map.put(ar[i],map.getOrDefault(ar[i],0) + 1);
            }
        }
        return ans;
    }

//    public static int longestSubArraySumEqZero(int[] ar[]) {
//
//    }


    public static void main(String[] args) {
        int[] n = {2,6,3,8,2,8,2,3,8,10,6};
        int[] q = {2,8,3};
        System.out.println("---------" + "Brute force" + " ---------");
        int[] res = frequencyBF(n,q);
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("---------" + "Hash Map" + " ---------");
        Integer[] n1 = {2,6,3,8,2,8,2,3,8,10,6};
        Integer[] q1 = {2,8,3};
        int[] res1 = frequencyBF(n,q);
        for(int i : res1) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println("---------" + "Count of distinct element" + " ---------");
        int[] nn = {3,5,6,5,4};
        System.out.println(countDistinctElem(nn));

        String s1 = "abcdmdcmopqrmm";
        System.out.println("---------" + "longest Substring Without Repeat" + " ---------");
        System.out.println(longestSubstringWithoutRepeat(s1));

        System.out.println("---------" + "first Non Repeating Elem" + " ---------");
        int[] a = {1,2,3,1,2,5};
        System.out.println(firstNonRepeatingElem(a));

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(10);
        temp.add(11);
        temp.add(12);
        temp.add(13);
        temp.add(14);
        temp.add(10);
        temp.add(13);
        temp.add(14);

        HashMap<Integer, Integer> ans = new HashMap<>();

        for(Integer i : temp) {
            ans.put(i,ans.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> val = new ArrayList<>();
        Integer[] nnn = {10,5,3,4,3,5,6};
        val.addAll(Arrays.asList(nnn));
        System.out.println(firstNonRepeatingElemArrayList(val));

        System.out.println("---------" + "pair exist = val(i) + val(j) = k using Set" + " ---------");
        int[] ba = {8,9,1,-2,4,5,11,-6,4};
        int k = 8;
        System.out.println(pairExistsSet(ba,k));

        System.out.println("---------" + "pair exist = val(i) + val(j) = k using HashMap" + " ---------");
        int[] baa = {2,5,2,5,8,5,2,8};
        int ka = 10;
        System.out.println(pairExistsHashMap(baa,ka));

        System.out.println("---------" + "subarray with sum = 0 using HashMap" + " ---------");
        int[] bba = {2,5,1,-3,4,3,1,-2,-3,2};
        System.out.println(subArraySumEqualZero(bba));

        System.out.println("---------" + "subarray with sum = k using HashSet" + " ---------");
        int[] b2 = {3,5,1,2,1,2};
        int k2 = 3;
        System.out.println(subArraySumEqualsK(b2,k2));

        System.out.println("---------" + "subarray with sum = k using HashMap" + " ---------");
        int[] b3 = {3,5,1,2,1,2};
        int k3 = 3;
        System.out.println(subArraySumEqualsKUsingMap(b3,k3));

        System.out.println("---------" + "Longest subarray with sum = 0 using using HashMap" + " ---------");
        int[] b4 = {2,5,3,4,-6,-1,5,-2,7,-10};
//        System.out.println(subArraySumEqualsKUsingMap(b4));


    }
}
