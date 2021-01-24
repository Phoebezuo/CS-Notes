import java.util.*;

public interface OrderedST {
    int size();

    int get(String key);

    void put(String key, int value);

    String min();

    String max();

    int rank(String key);

    List<String> keys(String l, String h);
}