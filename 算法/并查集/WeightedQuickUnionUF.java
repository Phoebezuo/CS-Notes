import java.util.Arrays;

public class WeightedQuickUnionUF extends UF {

    // keep the depth of each parent
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        super(N);
        this.sz = new int[N];
        Arrays.fill(this.sz, 0);
    }

    @Override
    public int find_root(int p) {
        int p_root = p;
        // iteratively traverse the level to find root
        while (parent[p_root] != -1) {
            p_root = parent[p_root];
        }
        return p_root;
    }


    @Override
    public boolean union(int p, int q) {
        int p_root = find_root(p);
        int q_root = find_root(q);

        // detect cycle
        if (p_root == q_root) { return false; }

        if (sz[p_root] < sz[q_root]) {
            parent[p_root] = q_root;
        } else if (sz[q_root] < sz[p_root]) {
            parent[q_root] = p_root;
        } else {
            parent[p_root] = q_root;
            sz[q_root]++;
        }

        return true;
    }
}
