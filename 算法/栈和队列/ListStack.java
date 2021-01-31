public class ListStack implements MyStack {

    private Node top = null;
    private int size = 0;

    private class Node {
        int item;
        Node next;
    }

    @Override
    public MyStack push(int item) {

        Node newTop = new Node();
        newTop.item = item;
        newTop.next = top;

        top = newTop;
        size++;

        return this;
    }

    @Override
    public int pop() {
        if (isEmpty()) { System.out.println("stack is empty"); }

        int item = top.item;
        top = top.next;
        size--;

        return item;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public int size() { return size; }

    @Override
    public int[] getArr() {
        int[] arr = new int[size];
        int idx = 0;

        Node cursor = top;
        while (cursor != null) {
            arr[idx++] = cursor.item;
            cursor = cursor.next;
        }

        return arr;
    }
}