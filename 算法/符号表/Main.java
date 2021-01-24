public class Main {
    public static void main(String[] args) {
//        list_unordered();
//        binary_search_ordered();
        binary_search_tree();
    }

    public static void list_unordered() {
        UnorderedST st = new ListUnorderedST();
        st.put("A", 1);
        st.put("C", 3);
        st.put("B", 2);

        System.out.println("Unordered ST get the value with key B: " + st.get("B"));
        System.out.println("Unordered ST get its size: " + st.size());
        st.delete("B");
        System.out.println("Unordered ST get its size: " + st.size());
    }

    public static void binary_search_ordered() {
        OrderedST st = new BinarySearchOrderedST(5);
        st.put("A", 1);
        st.put("C", 3);
        st.put("B", 2);
        st.put("E", 5);
        st.put("D", 4);

        System.out.println("Ordered ST get the value with key B: " + st.get("B") + ", with rank: " + st.rank("B"));
        System.out.println("Ordered ST get its size: " + st.size() + ", with keys from A to D: " + st.keys("A", "D"));
        System.out.println("Ordered ST has min: " + st.min() + ", max: " + st.max());
    }

    public static void binary_search_tree() {
        BST st = new BST();
        st.put("A", 6);
        st.put("B", 5);
        st.put("E", 7);
        st.put("C", 4);
        st.put("D", 2);
        st.put("G", 1);
        st.put("F", 8);

        System.out.println("BST get the value with key B: " + st.get("B") + ", with rank: " + st.rank("B"));
        System.out.println("BST get its size: " + st.size() + ", with keys from A to D: " + st.keys("A", "D"));
        System.out.println("BST has min: " + st.min() + ", max: " + st.max());

        st.deleteMin();
        System.out.println("BST after delete min, current min is: " + st.min());
        st.deleteMax();
        System.out.println("BST after delete max, current max is: " + st.max());
    }
}