package DSA;

import java.util.Stack;

public class QueueUsingTwoStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue element to the end of the queue
    public void enqueue(T element) {
        stack1.push(element);
    }

    // Dequeue element from the front of the queue
    public T dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // Outputs 1
        System.out.println(queue.dequeue()); // Outputs 2

        queue.enqueue(4);

        System.out.println(queue.dequeue()); // Outputs 3
        System.out.println(queue.dequeue()); // Outputs 4

        // Uncommenting the following line will throw a RuntimeException
        // System.out.println(queue.dequeue());
    }
}
