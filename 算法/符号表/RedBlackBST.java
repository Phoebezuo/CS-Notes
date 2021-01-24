//https://www.youtube.com/playlist?list=PL9xmBV_5YoZNqDI8qfOZgzbqahCUmUEin

public class RedBlackBST extends BST {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x) {
        if (x == null) { return false; }
        return x.color == RED;
    }

    public Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left; // y.left = between A and B
        y.left = x;

        y.color = x.color;
        x.color = RED;

        y.size = x.size;
        recalculateSize(x);
        return y;
    }

    public Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right; // y.right = between A and B
        y.right = x;

        y.color = x.color;
        x.color = RED;

        y.size = x.size;
        recalculateSize(x);
        return y;
    }

    void flipColors(Node x) {
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
    }

    @Override
    public void put(String key, int value) {
        root = put(root, key, value);
        root.color = BLACK;
    }
    private Node put(Node x, String key, int value) {

        // when the key is not in tree, insert a new key,
        // calculate its size and set its color to red
        if (x == null) {
            Node node = new Node(key, value, 1);
            node.color = RED;
            return node;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.val = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }

        // if right is red but left is black, rotate left
        if (isRed(x.right) && !isRed(x.left)) { x = rotateLeft(x); }

        // if continuos 2 nodes are red, rotate right
        if (isRed(x.left) && isRed(x.left.left)) { x = rotateRight(x); }

        // if both left and right are red, flip the color 
        if (isRed(x.left) && isRed(x.right)) { flipColors(x); }

        recalculateSize(x);
        return x;
    }
}