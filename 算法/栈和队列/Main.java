import java.util.*;

public class Main {

    private static MyStack myStack;
    private static MyQueue myQueue;

    public static void main(String[] args) {
//        ArrayStack();
        ListStack();
//        ListQueue();
    }

    private static void ArrayStack() {
        myStack = new ArrayStack();
        myStack = myStack.push(3).push(5).push(8);
        System.out.println("Array Stack after pusing: " + Arrays.toString(myStack.getArr()));

        int last = myStack.pop();
        System.out.println("Array Stack after pop once" + Arrays.toString(myStack.getArr()));
    }

    private static void ListStack() {
        myStack = new ListStack();
        myStack = myStack.push(3).push(5).push(8);
        System.out.println("List Stack after pusing: " + Arrays.toString(myStack.getArr()));

        int last = myStack.pop();
        System.out.println("List Stack after pop once" + Arrays.toString(myStack.getArr()));
    }

    private static void ListQueue() {
        myQueue = new ListQueue();
        myQueue = myQueue.add(3).add(5).add(8);
        System.out.println("List Queue after adding: " + Arrays.toString(myQueue.getArr()));

        int first = myQueue.remove();
        System.out.println("List Queue after remove once: " + Arrays.toString(myQueue.getArr()));
    }
}