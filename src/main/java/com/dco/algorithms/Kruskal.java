package com.dco.algorithms;

import com.dco.algorithms.uf.UnionFind;
import com.dco.ds.Edge;
import com.dco.ds.Graph;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal extends MSTAlgorithm {

    @Getter @Setter
    private List<Edge> wannabes;

    public Kruskal(Graph graph) {
        super(graph);
        uf = new UnionFind(graph.getN());
        mst = new ArrayList<>();
        wannabes = new ArrayList<>();
        wannabes.addAll(graph.getEdges());
    }

    @Override
    public void findMST() {
//        Collections.sort(wannabes, (o1, o2) -> o1.getWeight();
        wannabes.sort(Comparator.comparing(Edge::getWeight));
        for (int i = 0, k = 1; i < graph.getCountEdges() && k < graph.getN(); i++) {
            if (!uf.find(wannabes.get(i).getLVert(), wannabes.get(i).getRVert())) {
                uf.unite(wannabes.get(i).getLVert(), wannabes.get(i).getRVert());
                mst.add(wannabes.get(i));
                k++;
            }
        }
        System.out.println("Kruskal has completed successfully");
    }
}
