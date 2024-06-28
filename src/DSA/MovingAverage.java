package DSA;

/**
 * Design a class to calculate the moving average of last N numbers in a stream of real numbers.
 *
 *
 * ********************** SOLUTION  ****************************************************************
 *
 *  We'll use a queue to keep track of the last N numbers and calculate the average efficiently.
 */

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private final int size;
    private final Queue<Integer> queue;
    private double sum;

    public MovingAverage(int size){
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val){
        if(queue.size() == size)
            sum -= queue.poll();
        queue.offer(val);
        sum += val;
        return sum/queue.size();
    }

    public static void main(String[] args){
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1)); // Output: 1.0
        System.out.println(ma.next(10)); // Output: 5.5
        System.out.println(ma.next(3)); // Output: 4.66667
        System.out.println(ma.next(5)); // Output: 6.0
    }
}
