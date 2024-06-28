package DSA;

/**
 *     ======================PROBLEM================================
 *
 *     You receive a bitstream (0 and 1). Continuously receive a stream of bit, each time,
 *     you have to determine whether the current value is divisibility by 3 and print True or False.
 *
 *
 *     ================= SOL ===============================================================
 *
 *     To determine whether the current value of a continuously received bitstream is divisible by 3,
 *     we can leverage the properties of modular arithmetic.
 *     Here's a step-by-step guide on how to implement this efficiently:
 *
 * Understanding Binary Representation and Modulus:
 *
 * When a new bit is appended to a binary number, it effectively doubles the previous number
 * and adds the new bit.
 * For example, if the previous number is N and the new bit is b,
 * the new number N' can be represented as N' = 2 * N + b.
 *
 * Modulo Operation:
 *
 * We only need to keep track of the number modulo 3.
 * If N % 3 == r, where r is the remainder when N is divided by 3, then:
 *  N' mod 3 = (2∗N+b) mod 3
 *
 * Using properties of modulus:
 *  (2∗N+b) mod 3 = ((2∗(N mod 3))+b) mod 3
 *
 * This means we can update the remainder directly using:
 *   r' = (2∗r+b) mod 3
 *
 * Algorithm:
 *
 * Initialize remainder to 0.
 * For each bit b in the bitstream:
 * Update the remainder:
 * remainder = (2 ∗ remainder + b) mod 3
 * Check if remainder is 0 (indicating divisibility by 3) and print the result.
 */


import java.util.Scanner;

public class BitstreamDivisibility {

    public static void processBits(String bits){
        int rem = 0;
        for(int i=0;i<bits.length();i++){
            int bit = Character.getNumericValue(bits.charAt(i));
            rem = (2*rem+bit)%3;
            boolean isDivisibleBy3 = rem == 0;
            System.out.println(isDivisibleBy3);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String bitstream = sc.nextLine();
            processBits(bitstream);
        }

    }
}
