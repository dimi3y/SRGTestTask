package com.dco.algorithms;

import com.dco.ds.Edge;
import com.dco.ds.Graph;
import com.dco.ds.UnionFind;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boruvka {

    @Getter @Setter
    private Graph graph;

    @Getter @Setter
    private Edge[] mst;

    @Getter @Setter
    private Edge[] wannabes;

    @Getter @Setter
    private Edge[] neighbors;

    @Getter @Setter
    private UnionFind uf;

    public Boruvka(Graph graph) {
        this.graph = graph;
        uf = new UnionFind(graph.getN());
        wannabes = new Edge[graph.getCountEdges()];
//        wannabes.addAll(graph.getEdges());
        neighbors = new Edge[graph.getN()];
        mst = new Edge[graph.getN()+1];
    }

    public Edge[] runBoruvka() {
        System.arraycopy(graph.getEdges().toArray(), 0, wannabes, 0, graph.getCountEdges());
        int N, k = 1;

        for(int E = graph.getCountEdges(); E != 0; E = N) {
            int h, i, j;

            for(h = 0; h < graph.getN(); h++) {
                neighbors[h] = null;
            }

            for(h = 0, N = 0; h < E; h++) {
                Edge e = wannabes[h];
                i = uf.find(e.getLVert());
                j = uf.find(e.getRVert());

                if (i == j) {
                    continue;
                }
                if(neighbors[i] == null || e.getWeight() < neighbors[i].getWeight()) {
                    neighbors[i] = e;
                }
                if(neighbors[j] == null || e.getWeight() < neighbors[j].getWeight()) {
                    neighbors[j] = e;
                }

                wannabes[N++] = e;
            }

            for (h = 0; h < graph.getN(); h++) {
                if (neighbors[h] != null) {
                    i = neighbors[h].getLVert();
                    j = neighbors[h].getRVert();

                    if (!uf.find(i, j)) {
                        uf.unite(i, j);
//                        mst.set(k++, neighbors.get(h));
                        mst[k++] = neighbors[h];
                    }
                }
//                System.out.println("-------------------");
//                for (Edge e : mst)
//                    if (e == null)
//                        System.out.println("NULL");
//                    else
//                        System.out.println(e.getLVert() + " - " + e.getRVert() + ":" + e.getWeight());
//                System.out.println("-------------------");
            }
        }
        System.out.println("Boruvka has completed successfully");
        return mst;
    }

}
