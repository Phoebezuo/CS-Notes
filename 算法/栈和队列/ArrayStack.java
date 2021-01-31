import java.util.*;

public class ArrayStack implements MyStack {

    private int[] arr = new int[1];
    private int size = 0;

    @Override
    public MyStack push(int item) {
        check();

        arr[size] = item;
        size++;

        return this;
    }

    @Override
    public int pop() {
        if (isEmpty()) { System.out.println("stack is empty"); }

        int item = arr[size - 1];
        arr[size-1] = Integer.MAX_VALUE;
        size--;

        check();
        return item;
    }

    private void check() {
        if (size >= arr.length) {
            resize(2 * arr.length);
        } else if (size > 0 && size <= arr.length / 4) {
            resize(arr.length / 2);
        }
    }

    private void resize(int size) {
        int[] tmp = new int[size];
        Arrays.fill(tmp, Integer.MAX_VALUE);
        for (int i = 0; i < this.size; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public int size() { return size; }

    @Override
    public int[] getArr() {
        int[] result = new int[size];
        System.arraycopy(arr, 0, result, 0, size);
        return result;
    }
}