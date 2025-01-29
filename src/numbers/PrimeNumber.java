package numbers;

public class PrimeNumber {
    public PrimeNumber(int num) {
        if(countFactors(num) == 2) {
            System.out.println("number: " + num + " is a prime number");
        } else {
            System.out.println("number: " + num + " is not a prime number");
        }
    }

    public static int countFactors(int n) {
        int count = 0;
        for(int i=1; i*i <= n; i++) {
            if (n % i == 0) {
                if(i == n / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /**
         * Test cases for countFactors = 24, 36
         * 36 has 1 less factor than regular case
         */
//        int num = 36;
//        System.out.println("Count of Factors: " + countFactors(num));

        PrimeNumber p;
//        p = new PrimeNumber(6);
        System.out.println(countFactors(6));
//        p = new PrimeNumber(11);
//        p = new PrimeNumber(12);
//        p = new PrimeNumber(27);
//        p = new PrimeNumber(100019);
//        p = new PrimeNumber(100020);

    }
}

