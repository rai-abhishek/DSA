package bitwiseManipulation;

public class BitsQ {
    public static int binaryToDecimal(int n) {
        int ans = 0;
        int power = 1;
        int num = n;

        while(num !=0) {
            int rem = num % 10;
            num = num / 10;
            ans += rem * power;
            power *= 2;
        }
        return ans;
    }

    public static int decimalToBinary(int n) {
        int ans = 0;
        int power = 1;
        int num = n;
        while( num != 0) {
            int rem = num % 2;
            num = num / 2;
            ans += rem * power;
            power *= 10;
        }
        return ans;
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


    public static String binaryAdditionOfString(String A, String B) {
        StringBuilder result = new StringBuilder();

        int i = A.length() - 1; // Pointer for string A
        int j = B.length() - 1; // Pointer for string B
        int carry = 0; // Variable to store carry value

        // Loop until both strings are processed or there's a carry
        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i >= 0) ? A.charAt(i--) - '0' : 0; // Get bit from A or 0
            int bitB = (j >= 0) ? B.charAt(j--) - '0' : 0; // Get bit from B or 0

            int sum = bitA + bitB + carry; // Calculate the sum
            result.append(sum % 2); // Append the least significant bit to result
            carry = sum / 2; // Update the carry
        }

        return result.reverse().toString(); // Reverse and return the final result
    }

    public static void main(String[] args) {
        int n = 1101;
        int n1 = 1011010;
        int n2 = 20;
        int n3 = 45;
        System.out.println("Binary to Decimal");
        System.out.println(binaryToDecimal(n));
        System.out.println(binaryToDecimal(n1));
        System.out.println("Decimal to Binary");
        System.out.println(decimalToBinary(n2));
        System.out.println(decimalToBinary(n3));

        System.out.println("Binary Addition");
        int b1 = 1101;
        int b2 = 1001;
        System.out.println(binaryAddition(b1,b2));

        /**
         * Java uses the following rules for integer literals:
         *
         * Decimal: If the number doesn't start with 0, it is treated as a decimal (base-10). Example: 123.
         * Octal: If the number starts with 0, it is treated as an octal (base-8). Example: 010 (octal) equals 8 (decimal).
         * Hexadecimal: If the number starts with 0x or 0X, it is treated as a hexadecimal (base-16). Example: 0xA equals 10 (decimal).
         * Binary: If the number starts with 0b or 0B, it is treated as a binary (base-2). Example: 0b101 equals 5 (decimal).
         */
        int b3 = 10110;
        int b4 = 111;    // java considers any number starting with 00 as octal. so to fix this either remove leading zeros or declare like int b4 = 0b00111 / 0B00111;
//        System.out.println(binaryAddition(b3,b4));

        System.out.println("Binary Addition of Strings");
        String b5 = "1010110111001101101000";
        String b6 = "1000011011000000111100110";    // java considers any number starting with 00 as octal. so to fix this either remove leading zeros or declare like int b4 = 0b00111 / 0B00111;
        String b7 = "100";
        String b8 = "11";
        System.out.println(binaryAdditionOfString(b7,b8));
    }
}
