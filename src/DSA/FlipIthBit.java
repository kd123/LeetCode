package DSA;

/**
 *
 To flip the
 𝑖
 i-th bit of a number without using the bitwise NOT operator (~),
 use the bitwise XOR operator (^).
 The XOR operation will flip a bit if the corresponding bit in the mask is 1.

 Here’s how I can do it:

 Create a mask where only the i-th bit is set to 1.
 XOR the number with this mask.
 Steps
 Create the mask:

 To create a mask with only the i-th bit set, I can use the left shift operation (1 << i).
 This shifts the number 1 left by i positions.
 Apply XOR:

 Use the XOR operator to flip the i-th bit.
 Example
 Suppose you have a number num and you want to flip its i-th bit.

 EX:-
 num = 29  # Example number: 29 (in binary: 11101)
 i = 3     # Index of the bit you want to flip (0-based index)

 Explanation
 1 << i creates a mask where only the i-th bit is 1.
 For example, if i = 3, the mask will be 1000 (in binary).
 num ^ mask flips the i-th bit in num.
 If the i-th bit is 1, it becomes 0, and if it is 0, it becomes 1.

 Output:-

 For the given example where num = 29 (binary 11101) and i = 3:

 The mask 1 << 3 results in 1000 (binary).
 XOR operation 11101 ^ 1000 results in 10101 (binary), which is 21 in decimal.
 So, flipping the 3rd bit of 29 results in 21.
 */

import java.util.Scanner;

public class FlipIthBit {

    public static int flipIthBit(int num, int i){
        int mask = 1<<i;
        return num^mask;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int num = Integer.parseInt(sc.nextLine()); //num = 29 binary = 11101
            int i = Integer.parseInt(sc.nextLine());  // i= 3
            System.out.println(flipIthBit(num,i));
        }
    }
}
