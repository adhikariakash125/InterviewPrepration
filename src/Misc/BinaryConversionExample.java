package Misc;

public class BinaryConversionExample {
    public static void main(String[] args) {
        int decimalNumber = 3;
        String binaryString = Integer.toBinaryString(decimalNumber);
        System.out.println("Decimal " + decimalNumber + " in binary: " + binaryString);

        int longDecimalNumber = 4;
        String longBinaryString = Long.toBinaryString(longDecimalNumber);
        System.out.println("Decimal " + longDecimalNumber + " in binary: " + longBinaryString);

        System.out.println((decimalNumber & longDecimalNumber)==0);
    }
}