package numbers;

import java.util.HashMap;

public class HashMaptesting {
    public static void wordFrequency(String str) {
        String[] words = str.split(" ");

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequency: " + frequencyMap);
    }

    public static int subarraySumEqualsTarget(int[] a, int b) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        int sum = 0;
        int count = 0;
        for(int num: a) {
            sum += num;
            if(prefixSumMap.containsKey(sum - b)) {
                count += prefixSumMap.get(sum - b);
            }
            prefixSumMap.put(sum,prefixSumMap.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "apple banana apple orange banana apple";
        wordFrequency(str);

        int[] arr = {2,1,3,4,5,10,2};
        int target = 12;
        System.out.println(subarraySumEqualsTarget(arr,target));

    }
}
