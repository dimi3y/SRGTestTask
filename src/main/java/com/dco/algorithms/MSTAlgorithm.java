package com.dco.algorithms;

import com.dco.algorithms.uf.UnionFind;
import com.dco.ds.Edge;
import com.dco.ds.Graph;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public abstract class MSTAlgorithm {

    @Getter @Setter
    protected Graph graph;

    @Getter @Setter
    protected List<Edge> mst;

    @Getter @Setter
    protected UnionFind uf;

    MSTAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public abstract void findMST();

    public void printMST() {
        mst.forEach(edge -> System.out.println(edge.toString()));
    }
}
