public class QuickUnionUF extends UF {

    public QuickUnionUF(int N) {
        super(N);
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

        parent[p_root] = q_root;
        return true;
    }
}
