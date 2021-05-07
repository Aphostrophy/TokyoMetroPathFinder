// Java implementation of Dijkstra's Algorithm
// using Priority Queue
package com.aphostrophy;
import java.util.*;
public class DPQ {
    public int dist[];
    public Set<Integer> settled;
    public PriorityQueue<Node> pq;
    List<List<Node>> adj;
    public int V;

    public DPQ(int V)
    {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    // Function for Dijkstra's Algorithm
    public void dijkstra(List<List<Node> > adj, int src)
    {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;
        while (settled.size() != V) {

            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // adding the node whose distance is
            // finalized
            settled.add(u);

            e_Neighbours(u);
        }
    }

    // Function to process all the neighbours
    // of the passed node
    private void e_Neighbours(int u)
    {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
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
