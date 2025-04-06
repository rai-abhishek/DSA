package sort;

public class MergeSort {

    public static int[] mergerTwoSortedArray(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while(i < a.length & j < b.length) {
            if(a[i] < b[j]) {
                res[k] = a[i];
                i++;
                k++;
            } else {
                res[k] = b[j];
                j++;
                k++;
            }
        }
        while(i < a.length) {
            res[k] = a[i];
            k++;
            i++;
        }

        while(j < b.length) {
            res[k] = b[j];
            k++;
            j++;
        }
        return res;
    }

    public static void mergeSort(int[] a, int low, int high) {
        if(low == high) return;
        int mid = (low + high) / 2;
        mergeSort(a,low,mid);
        mergeSort(a,mid + 1, high);
        mergerTwoSortedArray(a,low,mid,high);
    }

    public static void mergerTwoSortedArray(int[] a,int low,int mid,int high) {
        int[] b = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while(i <= mid && j <= high) {
            if(a[i] <= a[j]) {
                b[k] = a[i];
                i++; k++;
            } else {
                b[k] = a[j];
                j++; k++;
            }
        }

        while(i <= mid) {
            b[k] = a[i];
            i++; k++;
        }
        while(j <= high) {
            b[k] = a[j];
            j++; k++;
        }

        for(int m = 0; m < b.length;m++) {
            a[m + low] = b[m];
        }
    }

    public static void main(String[] args) {
        int[] a = {3};
        int[] b = {-4,-3};
        System.out.println("-----merge two sorted array-----");
        int[] res = mergerTwoSortedArray(a,b);
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("-----merge sort-----");
        int[] c = {3,10,6,8,15,2,12,18,17};
        mergeSort(c,0,c.length - 1);
        for(int i : c) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
