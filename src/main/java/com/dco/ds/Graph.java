package com.dco.ds;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    @Getter
    @Setter
    private int n;

    @Getter
    @Setter
    private List<Edge> edges;

    public Graph(int n, int[][] matrix) {
        this.n = n;
        edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    edges.add(new Edge(matrix[i][j], i, j));
                }
            }
        }
    }

    public Graph(int n, List<Edge> edges) {
        this.n = n;
        this.edges = edges;
    }

    public int getCountEdges() {
        return edges.size();
    }

    public Edge edge(int v, int w) {
        for (Edge e : edges) {
            if (e.getLVert() == v & e.getRVert() == w || e.getLVert() == w & e.getRVert() == v) {
                return e;
            }
        }
        return null;
    }

}
