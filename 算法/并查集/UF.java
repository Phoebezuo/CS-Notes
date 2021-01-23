// https://www.bilibili.com/vparenteo/BV13t411v7Fs?from=search&separent=17292757166605147726

import java.util.Arrays;

public abstract class UF {

    protected int[] parent;

    public UF(int N) {
        parent = new int[N];
        Arrays.fill(parent, -1);
    }

    public abstract int find_root(int p);

    /**
    return true if union successful, else false
     */
    public abstract boolean union(int p, int q);
}
