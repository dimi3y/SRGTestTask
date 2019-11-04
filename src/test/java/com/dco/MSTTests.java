package com.dco;

import com.dco.algorithms.Boruvka;
import com.dco.algorithms.Kruskal;
import com.dco.algorithms.MSTAlgorithm;
import com.dco.ds.Graph;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MSTTests {

    @ParameterizedTest
    @ValueSource(ints = {7, 8})
    public void testBoruvkaPositive(int n) {
        Graph graph = new Graph(n, GraphUtils.getMatrixWithSize(n));
        MSTAlgorithm algorithm = new Boruvka(graph);
        algorithm.findMST();
        assertTrue(GraphUtils.resultContainsAllEdges(n, algorithm.getMst()));
        algorithm.printMST();
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 8})
    public void testKruskalPositive(int n) {
        Graph graph = new Graph(n, GraphUtils.getMatrixWithSize(n));
        MSTAlgorithm algorithm = new Kruskal(graph);
        algorithm.findMST();
        assertTrue(GraphUtils.resultContainsAllEdges(n, algorithm.getMst()));
        algorithm.printMST();
    }
}
