package bitwiseManipulation;

public class AdvancedBitwiseManipulation {
    public static void evenOdd(long a) {
        if((a&1) == 1) {
            System.out.println("Number " + a + " is odd");
        } else if((a&1) == 0) {
            System.out.println("Number " + a + " is even");
        }
    }

    public static int findUniqueElement(int[] a) {
        int ans = 0, n = a.length;

        for(int i = 0; i < n; i++){
            ans = a[i] ^ ans;
        }
        return ans;
    }

    /**  <h1>Left operator uses</h1>
     * OR - set <br/>
     * AND - check <br/>
     * XOR - toggle
     */

    public static int setUsingLeftOperator(int num, int b) {
        return (num | (1 << b));
    }

    public static void checkUsingLeftOperator(int num, int b) {
        if((num & (1 << b)) != 0) {
            System.out.println("Set");
        } else System.out.println("UnSet");
    }

    public static int toggleUsingLeftOperator(int num, int b) {
        return (num ^ (1 << b));
    }

    public static int countSetBitsUsingFor(int n) {
        int count = 0;
        for(int i = 0; i < 32;i++) {
            if((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static int countSetBitsUsingWhile(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /** <h1>Given three numbers A, B, C. Create the number with A number of Zeros, B number of ones and C number of zeros</h1>
     *
     *
     */

    public static int createNumber010(int A, int B, int C) {
        //A of no use as it is leading zeros. Similarly C is also of no use
        int ans = 0;
        for(int i = C; i < B + C; i++) {
            ans = (ans | (1 << i));
        }
        return ans;
    }

    public static int createNumber101(int A, int B, int C) {
        int ans = 0;
        for(int i = 0; i < C;i++) {
            ans = (ans | (1 << i));
        }

        for(int i = B + C; i < B + C + A; i++) {
            ans = (ans | (1 << i));
        }
        return ans;
    }

    /**
     * <h2>Given an integer array of size N, where all the elements occur thrice except one element. FInd that unique element</h2>
     */

    public static int thriceRepeatFindUnique(int[] a) {
        int ans = 0;
        int n = a.length;
        for(int i = 0; i < 32; i++) {
            int countSetBits = 0;
            for(int j = 0; j < n;j++) {
                if((a[j] & (1 << i)) != 0) {
                    countSetBits++;
                }
            }
            if(countSetBits % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }

    /**
     * Given an integer array of size N where all elements repeat twice except two. Find those two elements.
     *
     */

    public static int[] findTwoUniqueElements(int[] a) {
        int n = a.length;
        // find XOR of all elements
        int val = 0;
        for(int i = 0;i < n; i++) {
            val = a[i] ^ val;
        }

        //find the first set bit
        int pos = -1;
        for(int i = 0; i < n; i++) {
            if((val & (1 << i)) != 0) {
                pos = i;
                break;
            }
        }

        //split numbers into two buckets by bit and take XOR
        int s1 = 0, s2 =0;
        for(int i = 0; i < n;i++) {
            if((a[i]& (1 << pos)) != 0) {
                s1 = s1 ^ a[i];
            } else {
                s2 = s2 ^ a[i];
            }
        }

        //return two buckets
        int[] ans = {s1, s2};
        return ans;
    }

    /**
     * <h2>given subarray consisting of 1s and 0s. Your task is to calculate the number of subarrays for which the bitwise OR
     * of all the elements in the subarray is 0.</h2>
     *
     */

    public static int bitWiseORZeros (int[] a) {
        int n = a.length;
        int count = 0, ans = 0;
        for(int i = 0; i < n;i++) {
            if(a[i] == 0) {
                count++;
            } else {
                ans += count * (count + 1) / 2;
                count = 0;
            }
        }
        ans += count * (count + 1) /2;
        return ans;
    }

    /**
     * <h1>given binary array,find number of subarrays having OR 1</h1>
     *
     */

    public static int bitWiseOROnes(int[] a) {
        int n = a.length;
        int count = 0, ans = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] == 0) {
                count++;
            } else {
                ans += count * (count + 1) / 2;
                count = 0;
            }
        }
        ans += count * (count + 1) / 2;
        return n * (n + 1) / 2 - ans;
    }


    public static void main(String[] args) {
        int a = 2342;
        int b = -1;
        long c = 232132131;
        evenOdd(a);
        evenOdd(b);
        evenOdd(c);

        int[] n = {2,7,2,7,4,6,4};
        System.out.println(findUniqueElement(n));
        int n1 = 10;
        int d = 2;
        // 10 = 1010
        //14 = 1110
        //8 = 1000
        System.out.println("-----SET-----");
        System.out.println(setUsingLeftOperator(n1,0));
        System.out.println("-----check-----");
        checkUsingLeftOperator(n1,d);

        System.out.println("-----Toggle-----");
        System.out.println(toggleUsingLeftOperator(n1,1));
        System.out.println("-----count set bits using For-----");
        System.out.println(countSetBitsUsingFor(12));
        System.out.println("-----count set bits using While-----");
        System.out.println(countSetBitsUsingWhile(12));

        System.out.println("-----Create Number format 0 1 0-----");
        int A = 4, B = 3, C = 2;
        // 000011100 = 28
        System.out.println(createNumber010(A,B,C));

        System.out.println("-----Create Number format 1 0 1-----");
        // 111100011 = 483
        System.out.println(createNumber101(A,B,C));

        System.out.println("-----Number repeating thrice, find unique-----");
        int[] nn = {5,7,5,4,7,11,11,9,11,7,5,4,4};
        System.out.println(thriceRepeatFindUnique(nn));

        System.out.println("-----Number repeating twice, find two unique-----");
        int[] nn1 = {4,5,4,1,6,6,5,2,1,2,39,10};
        int[] ans = findTwoUniqueElements(nn1);
        for(int r: ans) {
            System.out.print(r + " ");
        }
        System.out.println();

        System.out.println("-----Bitwise OR operator = 0-----");
        int[] nn2 = {0,0,1,1,0,1,0,0};
        System.out.println(bitWiseORZeros(nn2));

        System.out.println("-----Bitwise OR operator = 1-----");
        int[] nn3 = {0,0,1,1,0};
        System.out.println(bitWiseOROnes(nn3));
    }
}
