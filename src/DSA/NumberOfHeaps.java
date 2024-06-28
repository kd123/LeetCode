package DSA;

/**
 * Find the total number of heaps that could be formed with n distinct integers.
 * It has a dynamic programming approach.
 *
 *
 * ***************************** SOLUTION **************************************************
 *
 * To find the total number of heaps that can be formed with
 * 𝑛
 * n distinct integers using a dynamic programming approach,
 * we need to consider the properties of heaps and
 * how they can be recursively broken down into smaller heaps.
 *
 *
 * -------------------Key Concepts-----------------
 *       Heap Properties:--
 *
 * A heap is a complete binary tree where each parent node is greater (for max-heap)
 * or smaller (for min-heap) than its children.
 *
 * Complete Binary Tree:
 *
 * A complete binary tree of n nodes has the first n/2 levels completely filled,
 * and the last level filled from left to right up to n nodes.
 *
 * Recursive Structure of Heaps:
 *
 * The root element must be the largest (for max-heap) or smallest (for min-heap) element.
 * The left and right subtrees must also be heaps.
 *
 * *********  Dynamic Programming Approach *************
 *
 * Count of Heaps:
 *
 * Let dp[n] be the number of distinct heaps that can be formed with n distinct elements.
 *
 * Divide and Conquer:
 *
 * Given the total n elements, the root is fixed.
 * The remaining n−1 elements are divided between the left and right subtrees.
 * The number of elements in the left subtree of a complete binary tree
 * with n nodes can be derived based on the height of the tree.
 *
 *
 * Heap Combination:
 *
 * For each possible split of n−1 elements into the left and right subtrees,
 * the number of heaps is the product of the number of heaps that can be formed with those elements.
 *
 *
 * -------------Steps to Solve------------------
 *
 * Calculate left(n):
 *
 * left(n): Number of nodes in the left subtree of a complete binary tree with n nodes.
 *
 * Dynamic Programming Array:
 *
 * Use a dp array where dp[n] represents the number of distinct heaps
 * that can be formed with n distinct elements.
 *
 * Binomial Coefficient Calculation:
 *
 * Use combinatorics to count the ways to choose the elements for the left subtree from the total n−1 elements.
 */

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfHeaps {
    private static int[] dp;
    private static int[][] nCk;
    private static int[] log2;

    public static void initialize(int n){
        dp= new int[n+1];
        Arrays.fill(dp,-1);
        nCk = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    nCk[i][j] = 1;
                else
                    nCk[i][j] = nCk[i-1][j-1] + nCk[i-1][j];
            }
        }

        log2 = new int[n+1];
        int currentPower = 1;
        int currentLog = -1;
        for(int i=1;i<=n;i++){
            if(currentPower == i){
                currentLog++;
                currentPower *=2;
            }
            log2[i] = currentLog;
        }
    }

    public static int left(int n){
        if(n==1)
            return 0;
        int h = log2[n];
        int numH = (1<<h);
        int numElementsLastLevel = n-((1<<h)-1);
        if(numElementsLastLevel >= (numH/2)){
            return (1<<h)-1;

        }else {
            return (1<<h) - 1 - ((numH/2) -numElementsLastLevel);
        }
    }

    public static int numberOfHeaps(int n){
        if(n<=1)
            return 1;
        if(dp[n] != -1)
            return dp[n];
        int l = left(n);
        dp[n] = nCk[n-1][l] * numberOfHeaps(l) * numberOfHeaps(n-1-l);
        return dp[n];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = Integer.parseInt(sc.nextLine());
            initialize(n);
            System.out.println(numberOfHeaps(n));
        }
    }
}
