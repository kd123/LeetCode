package DSA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two positive integers x and y, and an array arr[] of positive integers.
 * We need to find the longest prefix index which contains an equal number of x and y.
 * Print the maximum index of largest prefix if exist otherwise print -1.
 *
 * EX:-
 * N=11
 * X=7  Y=42
 * arr[] = [ 7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7 ]
 * Output: 9
 * Explanation: The longest prefix with same
 * number of occurrences of 7 and 42 is:
 * 7, 42, 5, 6, 42, 8, 7, 5, 3, 6
 *
 *
 * Ex:-
 * input:
 * N=3
 * X=1 Y=2
 * arr[] = [ 1,2,2 ]
 * Output: 1
 */

public class LongestEqualPrefix {

    public static int findIndex(int[] ar, int x, int y, int n){
        int xN=0;
        int yN=0;
        int result = -1;
        for(int i=0;i<n;i++){
            if(ar[i] == x)
                xN++;
            if(ar[i]==y)
                yN++;
            if(xN!=0 && xN==yN)
                result = i;
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = Integer.parseInt(sc.nextLine());
            int x = Integer.parseInt(sc.nextLine());
            int y = Integer.parseInt(sc.nextLine());
            int[] ar = Arrays.stream(sc.nextLine()
                                        .trim()
                                        .split(",")
                                     ).mapToInt(Integer::parseInt)
                                     .toArray();
            System.out.println(findIndex(ar,x,y,n));
        }
    }
}
