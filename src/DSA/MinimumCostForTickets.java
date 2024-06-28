package DSA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * There're 3 kinds of the bus ticket.
 * 1: ticket 1 cost 2 and can be used for a day.
 * 2: ticket 2 cost 7 and can be used for a consecutive 7 days.
 * 3: ticket 3 cost 25 can be used for a month.
 * Assume month here means 30 consecutive days.
 *
 * Now there's an array filled with elements. Each element value is a date for a person to travel.
 * This array has already been sorted in ascending order, like {1,3,4,5,11,12,23,24,30}.
 * The final day is 30th and the first day is 1st.
 *
 * So for any given array from a person to travel, how can this person cost least?
 */

public class MinimumCostForTickets {

    public static int mincostTickets(int [] days){
        int n= days.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1] +2;
            int j= i-1;
            while(j>=0 && days[i-1]-days[j]<7)
                j--;
            dp[i] = Math.min(dp[i],dp[j+1]+7);
            j=i-1;
            while (j>=0 && days[i-1]-days[j]<30)
                j--;
            dp[i] = Math.min(dp[i],dp[j+1]+30);
        }
        return dp[n];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true) {
            int[] days = Arrays.stream(sc.nextLine().trim().split(",")
                                        ).mapToInt(Integer::parseInt).toArray();
            System.out.println(mincostTickets(days));
        }
    }
}
