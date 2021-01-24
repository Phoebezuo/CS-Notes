import java.util.*;

public class BinarySearchOrderedST implements OrderedST {

    private String[] keys;
    private int[] values;
    private int size = 0;

    public BinarySearchOrderedST(int capacity) {
        keys = new String[capacity];
        values = new int[capacity];
    }

    @Override
    public int size() { return size; }

    @Override
    public int rank(String key) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    @Override
    public List<String> keys(String l, String h) {
        List<String> list = new ArrayList<>();

        int index = rank(l);
        while (keys[index].compareTo(h) <= 0) {
            list.add(keys[index]);
            index++;
        }
        return list;
    }

    @Override
    public void put(String key, int value) {
        int index = rank(key);

        // if key is already in the list, update its value
        if (index < size && keys[index].compareTo(key) == 0) {
            values[index] = value;
            return;
        }

        // else, insert a new node, move all element after inserting node towards back
        for (int j = size; j > index; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    @Override
    public int get(String key) {
        int index = rank(key);
        if (index < size && keys[index].compareTo(key) == 0) {
            return values[index];
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public String min() { return keys[0]; }

    @Override
    public String max() { return keys[size - 1]; }
}