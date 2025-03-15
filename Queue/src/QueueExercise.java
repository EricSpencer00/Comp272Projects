import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExercise{

    public static void main(String[] args){
        //create queue using built in Java interface with linked list
        Queue<Integer> queue = new LinkedList<>();
        //offer or push items into queue
        queue.add(1);
        queue.add(1);
        queue.add(3);
        queue.add(5);
        //call methods
        System.out.println(queue);
        recursionQueueReverse(queue);
        System.out.println(queue);
        reverseItems(queue, 3);
        System.out.println(queue);
    }

    /*
    * as you take off the bottom of the queue
    * */
    public static void recursionQueueReverse(Queue<Integer> queue) {
        if(!queue.isEmpty()) {
            int front = queue.poll();
            recursionQueueReverse(queue);
            queue.add(front);
        }
    }

    public static void reverseItems(Queue<Integer> queue, int k) {
        if(k <= 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value");
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for(int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.poll());
        }
    }

    /*Given an array of 1s and 0s, where 1 is offer and 0 is poll, return whether the
number of operations can be completed with a queue (without errors or
exeptions).
Input: [1,1,0*/
    public static boolean canBeCompleted(Queue<Integer> queue) {
        return false;
    }
}
