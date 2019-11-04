package com.dco;

import com.dco.algorithms.Boruvka;
import com.dco.ds.Graph;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int n = 0;
        int[][] matrix = null;
        Graph graph = null;

        Scanner sc = new Scanner(System.in);
        int action;

        do {
            System.out.println("1 - enter adjacency matrix size (n, m)");
            System.out.println("2 - choose minimum spanning tree building algorithm");
            System.out.println("3 - find minimum spanning tree");
            System.out.println("4 - print matrix");
            System.out.println("0 - exit program");
            System.out.print("Choose action: ");

            if (!sc.hasNextInt()) {
                System.out.println("Enter valid int action");
            } else {
                action = sc.nextInt();

                switch (action) {
                    case 1:
                        System.out.print("Enter matrix size: ");
                        n = sc.nextInt();
                        matrix = new int[n][n];
//                        System.out.println("Enter matrix");
//                        for(int i = 0; i < n; i++) {
//                            for(int j = 0; j < n; j++) {
//                                matrix[i][j] = sc.nextInt();
//                            }
//                        }
                        break;

                    case 2:
                        System.out.println("Generated matrix");
                        Random r = new Random();

                        for(int i = 0; i < n; i++) {
                            for(int j = 0; j < n; j++) {
                                matrix[i][j] = r.nextInt(2) * r.nextInt(10);
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println();
                        }

                        graph = new Graph(n, matrix);
                        break;

                    case 3:
                        assert graph != null;
                        Boruvka boruvka = new Boruvka(graph);
                        boruvka.runBoruvka();
                        break;

                    case 4:
//                        Matrix matr = new Matrix(n);
//                        matr.readMatrix();
//                        matr.printMatrix();

                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        break;
                }
            }

        } while (true);

    }
}
