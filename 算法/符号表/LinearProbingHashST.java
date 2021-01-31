public class LinearProbingHashST implements UnorderedST {
    private int size = 0;
    private int capacity = 16;
    private String[] keys;
    private int[] values;

    public LinearProbingHashST() {
        init();
    }

    public LinearProbingHashST(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        keys = new String[capacity];
        values = new int[capacity];
    }

    /**
     * Calculate the index of key in hash array
     * @param key
     * @return index
     */
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    @Override
    public int size() { return size; }

    private void resize() {
        // keep size/capacity bewteen 1/4 and 1/2
        if (size >= capacity / 2) {
            resize(2 * capacity);
        } else if (size <= capacity / 8) {
            resize(capacity / 2);
        }
    }

    private void resize(int new_capacity) {
        // copy the origin content into new hash ST
        LinearProbingHashST t = new LinearProbingHashST(new_capacity);
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                t.putInternal(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        capacity = t.capacity;
    }

    @Override
    public int get(String key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public void put(String key, int value) {
        resize();
        putInternal(key, value);
    }

    private void putInternal(String key, int value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            // update the value, if key is already exist
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        // otherwise, insert a new key
        keys[i] = key;
        values[i] = value;
        size++;
    }

    @Override
    public void delete(String key) {
        int i = hash(key);
        while (keys[i] != null && !key.equals(keys[i])) {
            i = (i + 1) % capacity;
        }

        // if key does not exists, return directly
        if (keys[i] == null) { return; }

        // initialize that key and value
        keys[i] = null;
        values[i] = Integer.MAX_VALUE;

        // re-insert the following keys and values
        i = (i + 1) % capacity;
        while (keys[i] != null) {
            String keyToRedo = keys[i];
            int valToRedo = values[i];
            keys[i] = null;
            values[i] = Integer.MAX_VALUE;
            size--;
            putInternal(keyToRedo, valToRedo);
            i = (i + 1) % capacity;
        }
        size--;
        resize();
    }
}
