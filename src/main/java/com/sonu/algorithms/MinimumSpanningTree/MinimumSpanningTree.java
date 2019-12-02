package com.sonu.algorithms.MinimumSpanningTree;

import com.sonu.datastructures.DisjointDatastructure.DisjointDatastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumSpanningTree {
    List<MSTNode> edges = new ArrayList<>();
    List<Integer> visitedNodes = new ArrayList<>();
    List<Integer> nodes = new ArrayList<>();
    DisjointDatastructure ds = new DisjointDatastructure();

    public void addEdge(int start, int end, int weight) {
        MSTNode temp = new MSTNode();
        temp.start = start;
        temp.end = end;
        temp.weight = weight;
        edges.add(temp);
        if( ! nodes.contains(start) ) {
            nodes.add(start);
            ds.add(start);
        }
        if( ! nodes.contains(end) ) {
            nodes.add(end);
            ds.add(end);
        }
    }

    public void getKruskalMST() {
        List<MSTNode> tempList = new ArrayList<>(this.edges);
        tempList.sort(Comparator.comparing( MSTNode::getWeight));
        int totalWeight = 0;

        for(MSTNode node: tempList) {
            if( visitedNodes.size() == nodes.size() ) {
                break;
            }

            if( this.visitedNodes.contains(node.start) && this.visitedNodes.contains(node.end)) {
                continue;
            }

            if( ! this.visitedNodes.contains(node.start) ) {
                visitedNodes.add(node.start);
            }

            if( ! this.visitedNodes.contains(node.end) ) {
                visitedNodes.add(node.end);
            }
            totalWeight += node.weight;
        }

        System.out.println("Weight of MST: "+totalWeight);
    }

    private boolean isConnectedGraph() {
        List<Integer> tempConnectionList = this.ds.getConnections();
        if( tempConnectionList.size() > 0) {
            int temp = tempConnectionList.get(0);
            for(int t: tempConnectionList) {
                if( t != temp) {
                    System.out.println("Not connected");
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MinimumSpanningTree mst = new MinimumSpanningTree();
        mst.addEdge(2,1,1);
        mst.addEdge(1,5,7);
        mst.addEdge(2,5,5);
        mst.addEdge(2,3,4);
        mst.addEdge(3,4,2);
        mst.addEdge(5,4,6);
        mst.addEdge(2,4,3);
        mst.getKruskalMST();
    }
}

class MSTNode {
    public int start = 0;
    public int end = 0;
    public int weight = 0;

    public int getWeight() { return weight; }
}
