package com.sonu.algorithms.Graphs.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public Map<Integer, GraphData> graph = new HashMap<>();
    private int rootLabel = Integer.MIN_VALUE;
    private boolean valueFound = false;

    public void addEdge(int a, int b) {
        if( ! this.graph.containsKey(b)) {
            GraphData temp = new GraphData();
            this.graph.put(b, temp);
        }
        if( this.graph.containsKey(a) ) {
            GraphData temp = this.graph.get(a);
            if( temp.neighbors.contains(b)) return;
            else temp.neighbors.add(b);
        } else {
            GraphData temp = new GraphData();
            temp.neighbors.add(b);
            this.graph.put(a, temp);
        }
    }

    public void setRoot(int a) {
        if( ! this.graph.containsKey(a) ) {
            System.out.println("Invalid root node: "+a);
            return;
        }
        GraphData temp = new GraphData();
        temp.neighbors.add(a);
        this.graph.put(Integer.MIN_VALUE, temp);
    }

    public void removeEdge(int a, int b) {
        if( this.graph.containsKey(a)) {
            this.graph.get(a).neighbors.remove(b);
        }
    }

    public boolean searchDFS(int data) {
        if(this.graph.get(Integer.MIN_VALUE) == null) {
            System.out.println("Root node may not have been assigned, please set and try again");
            return false;
        }
        this.valueFound = false;
        DFS(Integer.MIN_VALUE, data);
        return this.valueFound;
    }

    private void DFS(int nodeLabel, int data) {
        if( this.valueFound ) return;
        if( nodeLabel == data ) {
            this.valueFound = true;
            return;
        }
        System.out.println("Visiting: "+nodeLabel);
        if( this.graph.get(nodeLabel).visited ) return;

        graph.get(nodeLabel).visited = true;
        for(int neighbor: this.graph.get(nodeLabel).neighbors) {
             DFS(neighbor, data);
        }
    }

    public boolean searchBFS(int data) {
        if(this.graph.get(Integer.MIN_VALUE) == null) {
            System.out.println("Root node may not have been assigned, please set and try again");
            return false;
        }
        this.valueFound = false;
        BFS(Integer.MIN_VALUE, data, new ArrayList<>());
        return this.valueFound;
    }

    private void BFS(int nodeLabel, int data, List<Integer> queue) {
        if( this.valueFound ) return;
        if( nodeLabel == data ) {
            this.valueFound = true;
            return;
        }
        System.out.println("Visiting: "+nodeLabel);
        this.graph.get(nodeLabel).visited = true;

        for(int neighbor: this.graph.get(nodeLabel).neighbors) queue.add(neighbor);
        int nextLabel = queue.get(0);
        queue.remove(0);
        BFS(nextLabel, data, queue);
    }

    public void resetVisited() {
        this.graph.forEach( (k, v) -> {
            v.visited = false;
        });
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1,2);
        graph.addEdge(1,6);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(6,7);
        graph.addEdge(7,5);
        graph.setRoot(1);
        System.out.println("Search 5: "+graph.searchDFS(5));
        System.out.println("Search 5: "+graph.searchBFS(5));
    }
}

class GraphData {
    public List<Integer> neighbors = new ArrayList<>();
    public boolean visited = false;
}
