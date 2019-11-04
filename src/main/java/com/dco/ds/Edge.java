package com.dco.ds;

import lombok.Getter;
import lombok.Setter;

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



}
