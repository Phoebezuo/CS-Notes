public class ListQueue implements MyQueue {

    private Node first;
    private Node last;
    int size = 0;

    private class Node {
        int item;
        Node next;
    }

    @Override
    public MyQueue add(int item) {

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()) {
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
        return this;
    }

    @Override
    public int remove() {
        if (isEmpty()) { System.out.println("queue is empty"); }

        Node node = first;
        first = first.next;
        size--;

        if (isEmpty()) { last = null; }

        return node.item;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public int size() { return size; }

    @Override
    public int[] getArr() {
        int[] arr = new int[size];
        int idx = 0;

        Node cursor = first;
        while (cursor != null) {
            arr[idx++] = cursor.item;
            cursor = cursor.next;
        }

        return arr;
    }
}