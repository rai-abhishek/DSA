package array.twoPointer;

public class RotateArrayByK {
    RotateArrayByK() {};

    // try moving the last number in the front k number of times
    public int[] bruteForce(int[] arr, int k) {
        int n = arr.length;

        for(int i = 0; i < k; i++) {
            int temp = arr[n-1];  // keep the last number in temp
            for (int j = n-2; j >=0; j--) {   //run the loop from second last number to 0 and shift data
                arr[j+1] = arr[j];
            }
            arr[0] = temp; // put the last number to position zero
        }
        return arr;
    }

    // using reverse array logic (optimise to O(n))
    /**
     * let's say array = [1,2,3,4,5,6,7,8,9,10] and k = 3
     * so  we can first reverse the array so array = [10,9,8,7,6,5,4,3,2,1]
     * then from 0 to k - 1 (till k), reverse the array again so array = [8,9,10,7,6,5,4,3,2,1]
     * then again k to n-1 (from k to n), reverse the array again so array = [8,9,10,1,2,3,4,5,6,7]
     * and if k > n, in that case we can take k mod of n because it will repeat in cycles.
     */
    public int[] usingOptimized(int[] arr, int k) {
        ReverseArray rr = new ReverseArray();
        int n = arr.length;
        if(k > arr.length) k = k % n;

        //reverse the entire array
        arr = rr.usingTwoPointer(arr);

        //reverse the first part from 0 to k-1
        arr = rr.partOfArray(arr,0,k-1);

        // reverse the second part from k to n-1
        arr = rr.partOfArray(arr,k,n - 1);
        return arr;
    }

    public static void main(String[] args) {
        RotateArrayByK r = new RotateArrayByK();
        ReverseArray rev = new ReverseArray();

        int[] n = {1,2,3,4,5,6,7,8,9,10};
        int[] n1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Original Array: ");
        rev.print(n);
        System.out.println("After Rotation using brute force: ");
        r.bruteForce(n,3);
        rev.print(n);

        System.out.println("After Rotation using optimization: ");
        r.usingOptimized(n1,3);
        rev.print(n1);

        System.out.println("After Rotation using optimization with k (= 100) > n: ");
        r.usingOptimized(n1,100);
        rev.print(n1);
    }
}
