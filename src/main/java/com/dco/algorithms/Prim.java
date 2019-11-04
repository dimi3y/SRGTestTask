package com.dco.algorithms;

import com.dco.ds.Edge;
import com.dco.ds.Graph;

import java.util.List;

public class Prim extends MSTAlgorithm {

    private List<Double> wt;

    private List<Edge> fr;

    public Prim(Graph graph) {
        super(graph);
    }

    @Override
    public void findMST() {
        int min = -1;

        for (int v = 0; min != 0; v = min) {
            min = 0;

            for (int w = 1; w < graph.getN(); w++) {
                if (mst.get(w) == null) {
                    double P;
                    Edge e = graph.edge(v, w);
                    if (e != null) {
                        P = (double) e.getWeight();
                        if (P < wt.get(w)) {
                            wt.set(w, P);
                            fr.set(w, e);
                        }
                        if (wt.get(w) < wt.get(min)) {
                            min = w;
                        }
                    }
                }
            }

            if (min != 0) {
                mst.set(min, fr.get(min));
            }
        }

    }
}
