package com.dco;

import com.dco.algorithms.Boruvka;
import com.dco.ds.Edge;
import com.dco.ds.Graph;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoruvkaTests {

    private static int[][] matrix7x7 = new int [][] {   {0, 7 , 0 , 4 , 0 , 0 , 0 },
                                                        {7, 0 , 11, 9 , 10, 0 , 0 },
                                                        {0, 11, 0 , 0 , 5 , 0 , 0 },
                                                        {4, 9 , 9 , 0 , 15, 6 , 0 },
                                                        {0, 10, 5 , 15, 0 , 12, 8 },
                                                        {0, 0 , 0 , 6 , 12, 0 , 13},
                                                        {0, 0 , 0 , 0 , 8 , 13, 0 }};

    private static int[][] matrix8x8 = new int [][] {   {0 , 32, 29, 0 , 0 , 60, 51, 31},
                                                        {32, 0 , 0 , 0 , 0 , 0 , 0 , 21},
                                                        {29, 0 , 0 , 0 , 0 , 0 , 0 , 0 },
                                                        {0 , 0 , 0 , 0 , 34, 18, 0 , 0 },
                                                        {0 , 0 , 0 , 34, 0 , 40, 51, 46},
                                                        {60, 0 , 0 , 18, 40, 0 , 0 , 0 },
                                                        {51, 0 , 0 , 0 , 8 , 0 , 0 , 25},
                                                        {31, 21, 0 , 0 , 46, 0 , 25, 0 }};

//    private static Graph graph;
//
//    @BeforeClass
//    public static void init() {
//        graph = new Graph(7, matrix7x7);
//    }

    private Edge[] result = null;

    @After
    public void printResult() {
        if (result != null) {
            for (Edge e : result) {
                if (e == null)
                    System.out.println("NULL");
                else
                    System.out.println("(" + e.getLVert() + ")-(" + e.getRVert() + "): " +  + e.getWeight());
            }
        }
    }

    @Test
    public void testGraphEdges() {
        Graph graph = new Graph(7, matrix7x7);
        int c = 0;
        for (Edge e : graph.getEdges()) {
            c++;
            System.out.println("(" + e.getLVert() + ")--" + e.getWeight() + "--(" + e.getRVert() + ")");
        }
        System.out.println("total: " + c);
    }

    @Test
    public void testBoruvkaPositive7x7() {
        Graph graph = new Graph(7, matrix7x7);
        Boruvka boruvka = new Boruvka(graph);
        result = boruvka.runBoruvka();
    }


    @Test
    public void testBoruvkaPositive8x8() {
        Graph graph = new Graph(8, matrix8x8);
        Boruvka boruvka = new Boruvka(graph);
        result = boruvka.runBoruvka();
    }


}
