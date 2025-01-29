package strings;

import javax.swing.plaf.nimbus.State;

public class StringBinaryAddition {
    public static String stringBinaryAddition(String A, String B) {
        StringBuilder res = new StringBuilder();
        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;
        int bitA = 0;
        int bitB = 0;
        int sum = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            if(i >= 0) {
                bitA = A.charAt(i) - '0';
            } else {
                bitA = 0;
            }
            if(j >= 0) {
                bitB = B.charAt(j) - '0';
            } else {
                bitB = 0;
            }

            sum = bitA + bitB + carry;
            res.append(sum % 2);

            carry = sum / 2;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static int binaryAddition(int n1, int n2) {
        int ans = 0;
        int carry = 0;
        int power = 1;
        int sum = 0;

        while (n1 != 0 || n2 !=0 || carry !=0 ){
            int rem1 = n1 % 10;
            int rem2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            sum = rem1 + rem2 + carry;
            ans += (sum % 2) * power;
            carry = sum / 2;
            power *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "1110000000010110111010100100111";
        String s2 = "101001";
        String ans = stringBinaryAddition(s1,s2);
        System.out.println(ans);
//        int n1 = 100;
//        int n2 = 11;
//        System.out.println(binaryAddition(n1,n2));

    }
}
