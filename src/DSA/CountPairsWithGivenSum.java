package DSA;
/**
 * Given an array of N integers, and an integer K, the task is to find the number of pairs of integers in the array whose sum is equal to K.
 *
 * Examples:
 *
 * Input: arr[] = {1, 5, 7, -1}, K = 6
 * Output:  2
 * Explanation: Pairs with sum 6 are (1, 5) and (7, -1).
 *
 * Input: arr[] = {1, 5, 7, -1, 5}, K = 6
 * Output:  3
 * Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountPairsWithGivenSum {

    public static int findNumberOfPairsWithGivenSum(int ar[],int k){
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for(int i=0;i<ar.length;i++){
            if(hm.containsKey(k-ar[i])) {
                count += hm.get(k - ar[i]);
            }
            if(hm.containsKey(ar[i])){
                hm.put(ar[i], hm.get(ar[i])+1);
            }else {
                hm.put(ar[i],1);
            }
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){;
            int [] ar = Arrays.stream(sc.nextLine()
                            .trim()
                            .split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int k = Integer.parseInt(sc.nextLine());
            System.out.println(findNumberOfPairsWithGivenSum(ar, k));
        }
    }
}
