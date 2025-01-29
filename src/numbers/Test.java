package numbers;

public class Test {
    public static void solve(int n) {
        int count =0;
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= Math.pow(3,i); j++) {
                count++;
                System.out.println("iteration: " + j + " value " + (int)(i+j) + "having count: " + count);
            }
        }
    }

    public static void main(String[] args) {
        solve(10);
    }
}
