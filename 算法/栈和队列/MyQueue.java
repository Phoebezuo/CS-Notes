public interface MyQueue {
    MyQueue add(int item);

    int remove();

    boolean isEmpty();

    int size();

    int[] getArr();
}