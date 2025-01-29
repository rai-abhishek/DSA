package numbers;

public class SumOfNaturalNumbers {
    SumOfNaturalNumbers(int num) {
        System.out.println("Sum of natural numbers " + num + " is: " + calculateSum(num));
    }

    public static int calculateSum(int n) {
        return n*(n + 1)/2;
    }

    public static void main(String[] args) {
        SumOfNaturalNumbers sum;
        sum = new SumOfNaturalNumbers(100);
        sum = new SumOfNaturalNumbers(1000);
        sum = new SumOfNaturalNumbers(94);
        sum = new SumOfNaturalNumbers(157);
        sum = new SumOfNaturalNumbers(23231123);
    }
}
