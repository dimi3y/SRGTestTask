package com.dco.ds;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Edge {

    @Getter @Setter
    private int weight;

    @Getter @Setter
    private int lVert;

    @Getter @Setter
    private int rVert;

    public Edge(int weight, int lVert, int rVert) {
        this.weight = weight;
        this.lVert = lVert;
        this.rVert = rVert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                lVert == edge.lVert &&
                rVert == edge.rVert;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, lVert, rVert);
    }
}
