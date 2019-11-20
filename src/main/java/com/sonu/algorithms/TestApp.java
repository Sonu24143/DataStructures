package com.sonu.algorithms;

import com.sonu.algorithms.Graphs.Search.Graph;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("======= ALGORITHMS =========");
        testGraphTraversal();
    }

    static void testGraphTraversal() {
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
