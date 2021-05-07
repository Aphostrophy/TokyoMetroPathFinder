// Java implementation of Dijkstra's Algorithm
// using Priority Queue
package com.aphostrophy;
import java.util.*;
public class AS {
    public double dist[];
    public Set<Integer> settled;
    public PriorityQueue<NodeStar> pq;
    List<List<NodeStar>> adj;
    public int V;

    public AS(int V)
    {
        this.V = V;
        dist = new double[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<NodeStar>(V, new NodeStar());
    }

    // Function for Dijkstra's Algorithm
    public void astar(List<List<NodeStar> > adj, int src, HashMap<Integer,Double> hn)
    {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new NodeStar(src, 0,hn.get(src)));

        // Distance to the source is 0
        dist[src] = 0;
        while (settled.size() != V) {

            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // adding the node whose distance is
            // finalized
            settled.add(u);

            e_Neighbours(u,hn);
        }
    }

    // Function to process all the neighbours
    // of the passed node
    private void e_Neighbours(int u, HashMap<Integer, Double> hn)
    {
        double edgeDistance = -1;
        double newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            NodeStar v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new NodeStar(v.node, dist[v.node],hn.get(v.node)));
            }
        }
    }

    public static boolean contains(int destinations[], int node, int othernode){
        int count=0;
        for(int i=0;i<destinations.length;i++){
            if(destinations[i]==node || destinations[i]==othernode){
                count++;
            }
            if(count==2){
                return true;
            }
        }
        return false;
    }

    public static int getId(int destinations[], int node){
        for(int i=0;i<destinations.length;i++){
            if(destinations[i]==node){
                return i;
            }
        }
        return -1;
    }

    // Driver code

}
