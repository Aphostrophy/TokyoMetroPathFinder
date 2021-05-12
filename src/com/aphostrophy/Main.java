package com.aphostrophy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String arg[])
    {
        int V = 0;
        int M = 4;
        int source = 0;
        HashMap<Integer,Double> HN = new HashMap<>();

        // Adjacency list representation of the
        // connected edges
        List<List<Node>> adj = new ArrayList<List<Node> >();
        List<List<Node> > subAdj = new ArrayList<List<Node>>();

        List<List<NodeStar>> starAdj = new ArrayList<List<NodeStar>>();
        List<List<NodeStar>> starSubAdj = new ArrayList<List<NodeStar>>();

        // Inputs for the DPQ graph

        try {
            File myObj = new File("src/com/aphostrophy/map.txt");
            Scanner myReader = new Scanner(myObj);
            String num = myReader.nextLine();
            // Initialize list for every node
            V = Integer.parseInt(num);
            for (int i = 0; i < V; i++) {
                List<Node> item = new ArrayList<Node>();
                List<NodeStar> starItem = new ArrayList<>();
                adj.add(item);
                starAdj.add(starItem);
            }

            for (int i = 0;i< M+1;i++){
                List<Node> item = new ArrayList<Node>();
                List<NodeStar> starItem = new ArrayList<>();
                subAdj.add(item);
                starSubAdj.add(starItem);
            }
            int i = 0;
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                if(data.equals("=")){
                    break;
                }
                HN.put(i,Double.parseDouble(data));
                i++;
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] row = data.split(" ");
                adj.get(Integer.parseInt(row[0])).add(new Node(Integer.parseInt(row[1]),Double.parseDouble(row[2])));
                starAdj.get(Integer.parseInt(row[0])).add(new NodeStar(Integer.parseInt(row[1]),Double.parseDouble(row[2]),HN.get(Integer.parseInt(row[0]))));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }

        // Case 1

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
        Long startTime = System.nanoTime();

        for(int j=0;j<V;j++) {
            DPQ dpq = new DPQ(V);
            dpq.dijkstra(adj, j);

            // Print the shortest path to all the nodes
            // from the source node
//            System.out.println("The shortest path from node :");
            for (int i = 0; i < dpq.dist.length; i++) {
                if (DPQ.contains(destinations, j, i)) {
                    int newj = DPQ.getId(destinations, j);
                    int newi = DPQ.getId(destinations, i);
                    subAdj.get(newj).add(new Node(newi, dpq.dist[i]));
                    graph[newi][newj] = dpq.dist[i];
                }
            }
        }

        // Printing the new sub graph
//        for(int j=0;j<M+1;j++){
//            DPQ dpq = new DPQ(M+1);
//            dpq.dijkstra(subAdj, j);
//            if(j!=0){
//                arr[indexCounter] = destinations[j];
//                indexCounter++;
//            }
//        }
        Long endTime = System.nanoTime();
        System.out.println("Dijkstra Runtime: " +  Double.toString((endTime.doubleValue() - startTime.doubleValue())/1000000) + " milisecond");
        startTime = System.nanoTime();
        System.out.println("Cost : " + GFG.travellingSalesmanProblem(graph,0,M+1));
        endTime = System.nanoTime();

        System.out.println("BF Runtime: " +  Double.toString((endTime.doubleValue() - startTime.doubleValue())/1000000) + " milisecond");

        graph = new double[M+1][M+1];
//        arr = new int[M];
//        indexCounter = 0;

        Long starStartTime = System.nanoTime();

        for(int j=0;j<V;j++) {
            AS as = new AS(V);
            as.astar(starAdj, j,HN);


            for (int i = 0; i < as.dist.length; i++) {
                if (AS.contains(destinations, j, i)) {
                    int newj = AS.getId(destinations, j);
                    int newi = AS.getId(destinations, i);
                    starSubAdj.get(newj).add(new NodeStar(newi, as.dist[i],HN.get(i)));
                    graph[newi][newj] = as.dist[i];
                }
            }
        }

        // Printing the new sub graph
//        for(int j=0;j<M+1;j++){
//            AS as = new AS(M+1);
//            as.astar(starSubAdj, j,HN);
//            if(j!=0){
//                arr[indexCounter] = destinations[j];
//                indexCounter++;
//            }
//        }
        Long starEndTime = System.nanoTime();
        System.out.println("AStar Runtime: " +  Double.toString((starEndTime.doubleValue() - starStartTime.doubleValue())/1000000) + " milisecond");

        starStartTime = System.nanoTime();
        TSP solver = new TSP(0, graph);

        System.out.println("Tour cost: " + solver.getTourCost());
        starEndTime = System.nanoTime();
        System.out.println("DP Runtime: " +  Double.toString((starEndTime.doubleValue() - starStartTime.doubleValue())/1000000) + " milisecond");
    }
}
