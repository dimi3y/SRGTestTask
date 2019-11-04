package com.dco.ds;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Graph {

    @Getter @Setter
    private int n;

    @Getter @Setter
    private List<Edge> edges;

    public Graph(int n, int[][] matrix) {
        this.n = n;
        edges = new ArrayList<>();
//        edges = new ArrayList<>(n*(n-1)/2);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    edges.add(new Edge(matrix[i][j], i, j));
                }
//                System.out.println(i + " " + j + ":" + matrix[i][j]);
            }
        }
    }

    public Graph(int n, List<Edge> edges) {
        this.n = n;
        this.edges = edges;
    }

    public int getMaxWeight() {
        return edges.stream().max(Comparator.comparingInt(Edge::getWeight)).get().getWeight();
    }

    public int getCountEdges() {
        return edges.size();
    }

    public static void main(String[] args) {
//        Graph graph = new Graph(null, Arrays.asList(new Edge(2, 0, 0),
//                new Edge(1, 0, 0),
//                new Edge(5, 0, 0),
//                new Edge(3, 0, 0)));
//        System.out.println(graph.getMaxWeight());
    }

}
