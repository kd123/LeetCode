package DSA;

import java.util.*;

/**
 *
 * ******************************** SOLUTION ***************************************************
 * To find the next greater element for each element in an array, you can use a stack-based approach.
 * This approach efficiently finds the next greater element for each element in
 * O(n) time complexity.
 *
 * Explanation:
 * Initialize a Stack:
 *
 * Use a stack to keep track of elements for which we haven't found the next greater element yet.
 *
 * Iterate Through the Array:
 *
 * For each element in the array, while the stack is not empty and the current element is greater than
 * the element corresponding to the index at the top of the stack:
 * Pop the index from the stack.
 * The current element is the next greater element for the popped index.
 * Push the current element's index onto the stack.
 * Remaining Elements in Stack:
 *
 * The elements left in the stack do not have a next greater element,
 * so you can set their next greater element to -1.
 */

public class NextGreaterElement {

    public static int[] findNextGreaterElements(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int[] nums = Arrays.stream(
                                            sc.nextLine()
                                                .trim()
                                                .split(",")
                                        ).mapToInt(Integer::parseInt).toArray();

            System.out.println(Arrays.toString(findNextGreaterElements(nums)));
        }
    }
}
