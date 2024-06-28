package DSA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSubarray {

    public static int longestConsecutiveSubarray(int[] nums){
        Set<Integer> set= new HashSet<>();
        int maxLen = 0;
        for(int num: nums)
            set.add(num);
        for(int num: nums){
            if(!set.contains(num-1)){
                int curNum = num;
                int curLen = 1;
                while(set.contains(curNum+1)){
                    curNum++;
                    curLen++;
                }
                maxLen = Math.max(curLen,maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            int[] ar = Arrays.stream(sc.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(longestConsecutiveSubarray(ar));
        }
    }
}
