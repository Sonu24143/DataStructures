package com.sonu.algorithms.ShortestPathGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BellmanFords {

    public static void main(String[] args) {
        //Matrix representation of a graph
        int[][] graph = {{0,10,999,999,999,8},
                {999,999,999,2,999,999},
                {999,1,999,999,999,999},
                {999,999,-2,999,999,999},
                {999,-4,999,999,999,999},
                {999,999,999,999,1,999}};

        //Initialize result and running result
        int[] result = new int[graph[0].length];
        int[] tempResult = new int[graph[0].length];
        for(int i=1,n=result.length; i<n; i++) {
            result[i] = 999;
            tempResult[i] = 999;
        }
        result[0] = 0;
        tempResult[0] = 0;

        // flag to stop when optimization is complete
        boolean poison = false;

        while (true) {
            if(poison) break;
            //For each node
            for(int i=0,n=graph[0].length; i<n; i++) {

                //For each edge
                for(int j=0,m=graph[0].length; j<m ; j++) {

                    //Source node undiscovered OR Source node is not connected to current node continue
                    if( tempResult[j] == 999 || graph[j][i] == 999 ) continue;

                    //Cost of edge from source to current
                    int cost = graph[j][i];

                    //New cost is sum cost to each source node + cost to each from source to current node
                    int updatedCost = cost + tempResult[j];

                    //If lower cost is found update the new cost
                    if(updatedCost < tempResult[i]) {
                        tempResult[i] = updatedCost;
                    }
                }
            }

            //Optimization: If the running result and result are the same after iteration, means there will
            // be no further optimization in distances
            boolean allSame = true;
            for(int i=0,n=result.length; i<n; i++) {
                if( result[i] != tempResult[i]) {
                    allSame = false;
                    break;
                }
            }

            //If running result and result are not same, then assign the running result to th result
            if( ! allSame ) {
                for(int i=0,n=result.length; i<n;i++) { result[i] = tempResult[i];}
            }

            //Kill the loop when optimal solution is reached.
            poison = allSame;
        }

        System.out.println("Solution with source as 0");
        for(int i=0,n=result.length; i<n;i++) {
            System.out.println(i+" : "+result[i]);
        }

    }

}
