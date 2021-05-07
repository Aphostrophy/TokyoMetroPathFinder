package com.aphostrophy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String arg[])
    {
        int V = 21;
        int M = 4;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node>> adj = new ArrayList<List<Node> >();
        List<List<Node> > subAdj = new ArrayList<List<Node>>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        for (int i = 0;i< M+1;i++){
            List<Node> item = new ArrayList<Node>();
            subAdj.add(item);
        }

        // Inputs for the DPQ graph

        // Case 1

//        adj.get(0).add(new Node(3,7));
//        adj.get(0).add(new Node(4,1));
//        adj.get(0).add(new Node(7,2));
//
//        adj.get(1).add(new Node(2,9));
//        adj.get(1).add(new Node(6,7));
//
//        adj.get(2).add(new Node(1,9));
//        adj.get(2).add(new Node(3,2));
//        adj.get(2).add(new Node(6,2));
//
//        adj.get(3).add(new Node(0,7));
//        adj.get(3).add(new Node(2,2));
//        adj.get(3).add(new Node(7,5));
//
//        adj.get(4).add(new Node(0,1));
//        adj.get(4).add(new Node(5,5));
//        adj.get(4).add(new Node(6,6));
//
//        adj.get(5).add(new Node(4,5));
//        adj.get(5).add(new Node(6,8));
//        adj.get(5).add(new Node(7,3));
//        adj.get(5).add(new Node(8,7));
//
//        adj.get(6).add(new Node(1,7));
//        adj.get(6).add(new Node(2,2));
//        adj.get(6).add(new Node(4,6));
//        adj.get(6).add(new Node(5,8));
//
//        adj.get(7).add(new Node(0,2));
//        adj.get(7).add(new Node(3,5));
//        adj.get(7).add(new Node(5,3));
//
//        adj.get(8).add(new Node(5,7));

        //Case 2
//        adj.get(0).add(new Node(1,10));
//        adj.get(0).add(new Node(2,6));
//        adj.get(0).add(new Node(3,2));
//
//        adj.get(1).add(new Node(0,10));
//        adj.get(1).add(new Node(4,7));
//
//        adj.get(2).add(new Node(5,3));
//        adj.get(2).add(new Node(0,6));
//
//        adj.get(3).add(new Node(5,5));
//        adj.get(3).add(new Node(0,2));
//
//        adj.get(4).add(new Node(5,2));
//        adj.get(4).add(new Node(6,5));
//        adj.get(4).add(new Node(7,6));
//        adj.get(4).add(new Node(1,7));
//
//        adj.get(5).add(new Node(2,3));
//        adj.get(5).add(new Node(3,5));
//        adj.get(5).add(new Node(4,2));
//        adj.get(5).add(new Node(7,4));
//        adj.get(5).add(new Node(8,12));
//
//        adj.get(6).add(new Node(4,5));
//        adj.get(6).add(new Node(7,3));
//
//        adj.get(7).add(new Node(4,6));
//        adj.get(7).add(new Node(5,4));
//        adj.get(7).add(new Node(6,3));
//        adj.get(7).add(new Node(8,5));
//
//        adj.get(8).add(new Node(7,5));
//        adj.get(8).add(new Node(5,12));

        // Tokyo Metro

        adj.get(0).add(new Node(1,0));

        adj.get(1).add(new Node(0,0));
        adj.get(1).add(new Node(2, 0));
        adj.get(1).add(new Node(6,170));
        adj.get(1).add(new Node(15,180));

        adj.get(2).add(new Node(1,0));

        adj.get(3).add(new Node(4,0));
        adj.get(3).add(new Node(7,170));
        adj.get(3).add(new Node(12,170));
        adj.get(3).add(new Node(16,170));

        adj.get(4).add(new Node(3,0));
        adj.get(4).add(new Node(5,0));

        adj.get(5).add(new Node(4,0));
        adj.get(5).add(new Node(9,170));
        adj.get(5).add(new Node(11,170));
        adj.get(5).add(new Node(18,170));

        adj.get(6).add(new Node(1,170));
        adj.get(6).add(new Node(7,0));
        adj.get(6).add(new Node(15,170));

        adj.get(7).add(new Node(6,0));
        adj.get(7).add(new Node(3,170));
        adj.get(7).add(new Node(8,0));
        adj.get(7).add(new Node(12,170));
        adj.get(7).add(new Node(16,170));

        adj.get(8).add(new Node(7,0));
        adj.get(8).add(new Node(9,0));

        adj.get(9).add(new Node(5,170));
        adj.get(9).add(new Node(8,0));
        adj.get(9).add(new Node(10,0));
        adj.get(9).add(new Node(11,170));
        adj.get(9).add(new Node(18,170));

        adj.get(10).add(new Node(9,0));

        adj.get(11).add(new Node(5,170));
        adj.get(11).add(new Node(9, 170));
        adj.get(11).add(new Node(18,170));

        adj.get(12).add(new Node(3,170));
        adj.get(12).add(new Node(7,170));
        adj.get(12).add(new Node(16,170));

        adj.get(13).add(new Node(14,170));
        adj.get(13).add(new Node(17,0));

        adj.get(14).add(new Node(13,170));
        adj.get(14).add(new Node(19,0));

        adj.get(15).add(new Node(1,180));
        adj.get(15).add(new Node(6,170));
        adj.get(15).add(new Node(16,0));

        adj.get(16).add(new Node(3,170));
        adj.get(16).add(new Node(7,170));
        adj.get(16).add(new Node(12,170));
        adj.get(16).add(new Node(15,0));
        adj.get(16).add(new Node(17,0));

        adj.get(17).add(new Node(13,0));
        adj.get(17).add(new Node(16,0));
        adj.get(17).add(new Node(19,170));

        adj.get(18).add(new Node(5,170));
        adj.get(18).add(new Node(9,170));
        adj.get(18).add(new Node(11,170));
        adj.get(18).add(new Node(19,0));

        adj.get(19).add(new Node(17,170));
        adj.get(19).add(new Node(18,0));
        adj.get(19).add(new Node(20,0));
        adj.get(19).add(new Node(14,0));

        adj.get(20).add(new Node(19,0));

        // Calculate the single source shortest path

        double graph[][] = new double[M+1][M+1];
        int arr[] = new int[M];
        int indexCounter = 0;

        Scanner s = new Scanner(System.in);
        int [] destinations = new int[M+1];
        destinations[0] = source;
        for(int i=1;i<M+1;i++){
            destinations[i] = s.nextInt();
        }
        for(int i=0;i<M+1;i++){
            System.out.println(destinations[i]);
        }
        long startTime = System.currentTimeMillis();

        for(int j=0;j<V;j++) {
            DPQ dpq = new DPQ(V);
            dpq.dijkstra(adj, j);

            // Print the shortest path to all the nodes
            // from the source node
//            System.out.println("The shortest path from node :");
            for (int i = 0; i < dpq.dist.length; i++) {
//                System.out.println(j + " to " + i + " is "
//                        + dpq.dist[i]);
                if (DPQ.contains(destinations, j, i)) {
                    int newj = DPQ.getId(destinations, j);
                    int newi = DPQ.getId(destinations, i);
                    subAdj.get(newj).add(new Node(newi, dpq.dist[i]));
                    graph[newi][newj] = dpq.dist[i];
                }
            }
        }

        // Printing the new sub graph
        for(int j=0;j<M+1;j++){
            DPQ dpq = new DPQ(M+1);
            dpq.dijkstra(subAdj, j);
            System.out.println("The shortest path from node :");
            for( int i = 0; i < dpq.dist.length; i++){
                int oldj = destinations[j];
                int oldi = destinations[i];
                System.out.println(oldj + " to " + oldi + " is " + dpq.dist[i]);
            }
            if(j!=0){
                arr[indexCounter] = destinations[j];
                indexCounter++;
            }
        }

        // Comparing subgraph to graph matrix
//        for(int i=0;i<M+1;i++){
//            System.out.println("The shortest path from node :");
//            for(int j=0;j<M+1;j++){
//                int oldj = destinations[j];
//                int oldi = destinations[i];
//                System.out.println(oldi + " to " + oldj + " is " + graph[j][i]);
//            }
//        }

        Permutation pa = new Permutation();
        List<List<Integer>> permute = pa.permute(arr);

        System.out.println("Permutations of sequence are:");
        System.out.println("=========================================");
        for(List<Integer> perm:permute)
        {
            System.out.print(perm + " -> ");
            int nodePositionMarker=source;
            int totalCost=0;
            for(int i=0;i<M;i++){
                totalCost +=  graph[DPQ.getId(destinations,nodePositionMarker)][DPQ.getId(destinations, perm.get(i))];
                nodePositionMarker = perm.get(i);
            }
            System.out.println(totalCost);
        }
        long endTime = System.currentTimeMillis();

        System.out.println(GFG.travellingSalesmanProblem(graph,0,M+1));
        System.out.println("Dijkstra Runtime: " +  Double.toString(endTime - startTime));

        TSP solver = new TSP(0, graph);

        // Prints: [0, 3, 2, 4, 1, 5, 0]
        System.out.println("Tour: " + solver.getTour());

        // Print: 42.0
        System.out.println("Tour cost: " + solver.getTourCost());
    }
}
