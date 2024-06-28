package DSA;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private static List<int[]> minStack;

    public MinStack(){
        minStack = new ArrayList<>();
    }

    public static void push(int val){
        if(minStack.size()==0){
            minStack.add(minStack.size(),new int[]{val,val});
            return;
        }
        int min = getMin();
        minStack.add(minStack.size(),new int[]{val, Math.min(min,val)});
    }

    public static void pop(){
         minStack.remove(minStack.size()-1);
    }

    public static int top(){
        return minStack.get(minStack.size()-1)[0];
    }
    public static int getMin(){
        return minStack.get(minStack.size()-1)[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.getMin());  // Output: 3
//        minStack.push(0);
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin());  // Output: 1
        minStack.pop();
        System.out.println(minStack.getMin());  // Output: 2
        minStack.pop();
        System.out.println(minStack.top());     // Output: 5
        System.out.println(minStack.getMin());  // Output: 3
    }
}
