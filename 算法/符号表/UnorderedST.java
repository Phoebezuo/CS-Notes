public interface UnorderedST {
    int size();

    int get(String key);

    void put(String key, int value);

    void delete(String key);
}