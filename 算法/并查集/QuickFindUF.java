public class QuickFindUF extends UF {

    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public int find_root(int p) {
        return parent[p];
    }

    @Override
    public boolean union(int p, int q) {
        int p_root = find_root(p);
        int q_root = find_root(q);

        // detect cycle
        if (p_root == q_root) { return false; }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == p_root) {
                parent[i] = q_root;
            }
        }

        return true;
    }
}
