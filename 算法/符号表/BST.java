import java.util.*;

public class BST implements OrderedST {

    protected Node root;

    protected class Node {
        String key;
        int val;
        Node left;
        Node right;
        int size;
        boolean color; // for red/black tree

        Node(String key, int val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    @Override
    public int size() { return size(root); }
    private int size(Node x) {
        if (x == null) { return 0; }
        return x.size;
    }

    protected void recalculateSize(Node x) {
        x.size = size(x.left) + size(x.right) + 1;
    }

    @Override
    public int get(String key) { return get(root, key); }
    private int get(Node x, String key) {
        if (x == null) { return Integer.MAX_VALUE; }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.val;
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return get(x.right, key);
        }
    }

    @Override
    public void put(String key, int value) { root = put(root, key, value); }
    private Node put(Node x, String key, int value) {

        // when the key is not in the tree, insert a new key, and
        // calculate its size correctly
        if (x == null) { return new Node(key, value, 1); }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.val = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }

        recalculateSize(x);
        return x;
    }

    /**
     * Find the greatest key that is samller or equal to searching key
     * @param key, the key that need to be searched
     * @return the value of the greatest key that is smaller or euqal to searching key
     */
    public String floor(String key) {
        Node x = floor(root, key);
        if (x == null) { return null; }
        return x.key;
    }

    private Node floor(Node x, String key) {
        if (x == null) { return null; }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) { return x; }
        if (cmp < 0) { return floor(x.left, key); }

        // if the searching key is greater than current root, find its right subtree
        // if the floor key is exists in its right subtree, then return that key
        // otherwise, return the current root
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    @Override
    public int rank(String key) { return rank(key, root); }
    private int rank(String key, Node x) {
        if (x == null) { return 0; }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return size(x.left);
        } else if (cmp < 0) {
            return rank(key, x.left);
        } else {
            // current root + number of node smaller then current root
            // + rank within right subtree
            return 1 + size(x.left) + rank(key, x.right);
        }
    }

    @Override
    public String min() { return min(root).key; }
    private Node min(Node x) {
        if (x == null) { return null; }
        if (x.left == null) { return x; }
        return min(x.left);
    }

    public void deleteMin() { root = deleteMin(root); }
    public Node deleteMin(Node x) {
        if (x.left == null) { return x.right; }
        x.left = deleteMin(x.left);
        recalculateSize(x);
        return x;
    }

    @Override
    public String max() { return max(root).key; }
    private Node max(Node x) {
        if (x == null) { return null; }
        if (x.right == null) { return x; }
        return max(x.right);
    }

    public void deleteMax() { root = deleteMax(root); }
    public Node deleteMax(Node x) {
        if (x.right == null) { return x.left; }
        x.right = deleteMax(x.right);
        recalculateSize(x);
        return x;
    }

    public void delete(String key) { root = delete(root, key); }
    private Node delete(Node x, String key) {
        if (x == null) { return null; }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            // delete its current root
            if (x.right == null) { return x.left; }
            if (x.left == null) { return x.right; }

            // swap the current root with min node in right subtree
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        recalculateSize(x);
        return x;
    }

    @Override
    public List<String> keys(String low, String high) { return keys(root, low, high); }
    private List<String> keys(Node x, String low, String high) {
        List<String> list = new ArrayList<>();
        if (x == null) { return list; }

        int cmp_low = low.compareTo(x.key);
        int cmp_high = high.compareTo(x.key);

        // the range is in the left subtree
        if (cmp_low < 0) { list.addAll(keys(x.left, low, high)); }

        // the range is current root
        if (cmp_low <= 0 && cmp_high >= 0) { list.add(x.key); }

        // the range is in the right subtree
        if (cmp_high > 0) { list.addAll(keys(x.right, low, high)); }
        return list;
    }
}
