package com.aphostrophy;

import java.util.Comparator;

// Class to represent a node in the graph
public class NodeStar implements Comparator<NodeStar> {
    public int node;
    public double cost;
    public double heuristics;

    public NodeStar()
    {
    }

    public NodeStar(int node, double cost, double heuristicCost)
    {
        this.node = node;
        this.cost = cost;
        this.heuristics = heuristicCost;
    }

    @Override
    public int compare(NodeStar node1, NodeStar node2)
    {
        if (node1.cost + node1.heuristics < node2.cost + node2.heuristics)
            return -1;
        if (node1.cost + node1.heuristics > node2.cost + node2.heuristics)
            return 1;
        return 0;
    }
}
