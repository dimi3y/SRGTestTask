package com.dco;

import com.dco.ds.Edge;

import java.util.Arrays;
import java.util.List;

public class GraphUtils {

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

    private static List<Edge> edges7x7, edges8x8;

    static {
        edges7x7 = Arrays.asList(new Edge(4, 0, 3),
                new Edge(7, 0, 1),
                new Edge(5, 2, 4),
                new Edge(6, 3, 5),
                new Edge(8, 4, 6),
                new Edge(10, 1, 4)
        );

        edges8x8 = Arrays.asList(new Edge(29, 0, 2),
                new Edge(21, 1, 7),
                new Edge(18, 3, 5),
                new Edge(34, 3, 4),
                new Edge(25, 6, 7),
                new Edge(31, 0, 7),
                new Edge(46, 4, 7)
        );
    }

    public static boolean resultContainsAllEdges(int size, List<Edge> mst) {
        List<Edge> correct;
        switch (size) {
            case 7:
                correct = edges7x7;
                break;

            case 8:
                correct = edges8x8;
                break;

            default:
                correct = null;
                break;
        }
        return correct != null && mst.containsAll(correct);
    }

    public static int[][] getMatrixWithSize(int size) {
        int [][] matrix = null;
        switch (size) {
            case 7:
                matrix = matrix7x7;
                break;

            case 8:
                matrix = matrix8x8;

            default:
                break;
        }
        return matrix;
    }
}
