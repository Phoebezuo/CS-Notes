public class ListUnorderedST implements UnorderedST {

    private Node first;

    private class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public int size() {
        int cnt = 0;
        Node cur = first;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }

    @Override
    public void put(String key, int value) {
        Node cur = first;

        // if find the key in the list, then update the value of that key
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        // otherwise, insert a new node
        first = new Node(key, value, first);
    }

    @Override
    public void delete(String key) {
        if (first == null) { return; }
        if (first.key.equals(key)) { first = first.next; }

        Node pre = first, cur = first.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                pre.next = cur.next;
                return;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }

    @Override
    public int get(String key) {
        Node cur = first;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return Integer.MAX_VALUE;
    }
}