package sort;

import java.util.*;
import java.util.stream.Collectors;

public class QuickSort {
    public static void pivotPartition(int[] ar) {
        int pivot = ar[0];
        int l = 1, r = ar.length - 1;
        while(l <= r) {
            if(ar[l] <= pivot) {
                l++;
            } else if ( ar[r] > pivot) {
                r--;
            } else {
                //swap ar[l] with ar[r]
                int temp = ar[l];
                ar[l] = ar[r];
                ar[r] = temp;
                l++;r--;
            }
        }
        // swap ar[0] with ar[r]
        int temp = ar[0];
        ar[0] = ar[r];
        ar[r] = temp;
    }

    public static void quickSort(int[] ar, int low, int high) {
        if( low >= high) return;
        int pi = partitioning(ar, low, high);
        quickSort(ar, low, pi - 1);
        quickSort(ar,pi + 1, high);
    }

    public static int partitioning(int a[], int low, int high) {
        int pivot = a[low];
        int l = low + 1, r = high;

        while(l <= r) {
            if(a[l] <= pivot){
                l++;
            } else if (a[r] > pivot) {
                r--;
            } else {
                //swap a[l] with a[r]
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;r--;
            }
        }
        //swap a[low] with a[r]
        int temp = a[low];
        a[low] = a[r];
        a[r] = temp;

        return r;
    }



    public static void main(String[] args) {
        System.out.println("---pivot partitioning");
        int[] a = {54,26,93,17,77,31,44,55,20};
        pivotPartition(a);
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("---Quick Sort");
        int[] b = {54,26,93,17,77,31,44,55,20};
        quickSort(b, 0, b .length-1);
        for(int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

        // Create a set to hold intermediate results
        Set<String> intermediateResults = new HashSet<>();
        List<String> result = listOfLists.stream()
                .flatMap(List::stream)              // Flatten the list of lists into a single stream
                .filter(s -> s.startsWith("S"))      // Filter elements starting with "S"
                .map(String::toUpperCase)            // Transform each element to uppercase
                .distinct()                          // Remove duplicate elements
                .sorted()                            // Sort elements
                .peek(s -> intermediateResults.add(s)) // Perform an action (add to set) on each element
                .collect(Collectors.toList());       // Collect the final result into a list
        result.toString();

        System.out.println("Final Result:");
        result.forEach(System.out::println);

    }

}
