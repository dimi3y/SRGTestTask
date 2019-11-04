package com.dco.algorithms;

import com.dco.algorithms.uf.UnionFind;
import com.dco.ds.Edge;
import com.dco.ds.Graph;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boruvka extends MSTAlgorithm{

    @Getter @Setter
    private List<Edge> wannabes;

    @Getter @Setter
    private List<Edge> neighbors;

    public Boruvka(Graph graph) {
        super(graph);
        uf = new UnionFind(graph.getN());
        mst = new ArrayList<>();
        wannabes = new ArrayList<>();
        wannabes.addAll(graph.getEdges());
        neighbors = new ArrayList<>(Arrays.asList(new Edge[graph.getN()]));
    }

    @Override
    public void findMST() {

        int N, k = 1;

        for(int E = graph.getCountEdges(); E != 0; E = N) {
            int h, i, j;

            Collections.fill(neighbors, null);

            for(h = 0, N = 0; h < E; h++) {
                Edge e = wannabes.get(h);
                i = uf.find(e.getLVert());
                j = uf.find(e.getRVert());

                if (i == j) {
                    continue;
                }
                if(neighbors.get(i) == null || e.getWeight() < neighbors.get(i).getWeight()) {
                    neighbors.set(i, e);
                }
                if(neighbors.get(j) == null || e.getWeight() < neighbors.get(j).getWeight()) {
                    neighbors.set(j, e);
                }
                wannabes.set(N++, e);
            }

            for (h = 0; h < graph.getN(); h++) {
                if (neighbors.get(h) != null) {
                    i = neighbors.get(h).getLVert();
                    j = neighbors.get(h).getRVert();

                    if (!uf.find(i, j)) {
                        uf.unite(i, j);
//                        mst.set(k++, neighbors.get(h));
                        mst.add(neighbors.get(h));
                        k++;
                    }
                }
            }
        }
        System.out.println("Boruvka has completed successfully");
    }

}
