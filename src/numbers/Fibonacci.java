package numbers;

public class Fibonacci {
    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println("fibonacci sum of n: " + fibonacci(15));
    }
}
