package com.dco;

import com.dco.algorithms.Boruvka;
import com.dco.algorithms.Kruskal;
import com.dco.algorithms.MSTAlgorithm;
import com.dco.algorithms.Prim;
import com.dco.ds.Graph;
import com.dco.ds.Matrix;

import java.util.Random;
import java.util.Scanner;

enum Menu{

    MAIN(
            "1 - enter adjacency matrix size\n" +
            "2 - generate adjacency matrix\n" +
            "3 - choose algorithm and find MST\n" +
            "4 - print matrix\n" +
            "0 - exit program\n" +
            "Choose action: "),
    ALGORITHM(
            "1 - find MST using Bouravka's algorithm\n" +
            "2 - find MST using Kurskal's algorithm\n" +
            "3 - find MST using Prim's algorithm\n" +
            "Choose option: "),
    MATRIX(
            "1 - generate matrix\n" +
            "2 - use matrix 7x7 template\n" +
            "2 - use matrix 8x8 template\n" +
            "Choose option: ");

    private String menu;

    Menu(String menu) {
        this.menu = menu;
    }

    public String getMenu(){ return menu;}
}

public class Main {

    public static void main(String[] args) {
        int n = 0;
//        int[][] matrix = null;
        Matrix matrix = null;
        Graph graph = null;
        MSTAlgorithm mstAlgorithm = null;


        Scanner sc = new Scanner(System.in);
        int action;

        do {
            System.out.println(Menu.MAIN.getMenu());

            if (!sc.hasNextInt()) {
                System.out.println("Enter valid int action");
            } else {

                action = sc.nextInt();

                switch (action) {
                    case 1:
                        System.out.print("Enter matrix size: ");
                        n = sc.nextInt();
                        matrix = new Matrix(n);
//                        matrix = new int[n][n];
                        break;

                    case 2:
                        if (n <= 0 | matrix == null) {
                            System.out.println("Enter valid matrix size first");
                            break;
                        }

                        System.out.println("Generated matrix");

                        matrix.generateMatrix();

                        matrix.printMatrix();

                        graph = new Graph(n, matrix.getMatrix());

                        break;

                    case 3:
                        if (graph == null) {
                            System.out.println("Generate matrix first");
                            break;
                        }
                        System.out.println(Menu.ALGORITHM.getMenu());
                        int option = sc.nextInt();

                        do {
                            switch (option) {
                                case 1:
                                    mstAlgorithm = new Boruvka(graph);
                                    break;

                                case 2:
                                    mstAlgorithm = new Kruskal(graph);
                                    break;

//                                case 3:
//                                    mstAlgorithm = new Prim(graph);
//                                    break;

                                default:
                                    System.out.println("Choose valid option");
                                    break;

                            }
                        } while (mstAlgorithm == null);

                        mstAlgorithm.findMST();
                        break;

                    case 4:
                        if (mstAlgorithm != null) {
                            mstAlgorithm.printMST();
                        } else {
                            System.out.println("Choose and run MST algorithm first");
                        }
                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Choose valid action");
                        break;
                }
            }

        } while (true);

    }
}
