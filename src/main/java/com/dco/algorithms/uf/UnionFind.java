package com.dco.algorithms.uf;

public class UnionFind {

    private int[] id;

    private int[] sz;

    public UnionFind(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int x) {
        while (x != id[x]) {
            x = id[x];
        }
        return x;
    }

    public boolean find(int p, int q) {
        return find(p) == find(q);
    }

    public void unite(int p, int q) {
        int i = find(p), j = find(q);

        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

}
