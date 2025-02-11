package array.prefixSum;

public class SpecialIndexes {
    SpecialIndexes() {};

    public int specialIndices(int[] ar) {
        System.out.println("------ Original Array ------");
        print(ar);
        int[] peven = new int[ar.length];
        int[] podd = new int[ar.length];

        //calculate prefix sum for even indexes
        peven[0] = ar[0];
        for(int i = 1; i < ar.length; i++) {
            if(i % 2 == 0) {
                peven[i] = peven[i-1] + ar[i];
            } else {
                peven[i] = peven[i-1];
            }
        }
        System.out.println("---- even prefix ----");
        print(peven);

        // Calculate prefix sum for odd indexes
        podd[0] = 0;
        for(int i = 1; i < ar.length;i++) {
            if(i % 2 != 0) {
                podd[i] = podd[i-1] + ar[i];
            } else {
                podd[i] = podd[i-1];
            }
        }
        System.out.println("---- odd prefix ----");
        print(podd);

        //calculate special index count
        /**
         * Seven(i) = Seven(0,i-1) + Sodd(i+1,n-1);
         * Seven(i) = Seven(i-1) + sodd(n-1) + sodd(i)  // formula Seven(i,j) = Seven(j) - Seven(i-1)
         * Same way for Sodd
         */
        int count = 0;
        for(int i = 0; i < ar.length;i++) {
            int n = ar.length;
            int se = 0;
            int so = 0;
            if(i == 0) { //first term is not required for i=0 calculation
                se = podd[n -1] - podd[i];
                so = peven[n -1] - peven[i];
            } else {
                se = peven[i-1] + podd[n -1] - podd[i];
                so = podd[i-1] + peven[n -1] - peven[i];
            }
            System.out.println("SE at i: " + i + " = " + se);
            System.out.println("SO at i: " + i + " = " + so);
            if(se == so) {
                count++;
            }
        }
        return count;
    }

    public void print(int[] n) {
        for(int i: n) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SpecialIndexes s = new SpecialIndexes();
        int[] n = {1,2,3,7,1,2,3};
        System.out.println(s.specialIndices(n));

    }
}
