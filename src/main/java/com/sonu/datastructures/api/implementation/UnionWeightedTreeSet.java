package com.sonu.datastructures.api.implementation;

import com.sonu.datastructures.api.UnionSet;

public class UnionWeightedTreeSet implements UnionSet {
    private int[] connection;
    private int[] weight;

    public UnionWeightedTreeSet(int n) {
        connection = new int[n];
        weight = new int[n];

        for(int i=0; i<n; i++) {
            connection[i] = i;
            weight[i] = 1;
        }
    }

    private int root(int i) {
        while ( connection[i] != i ) i = connection[i];
        return i;
    }

    @Override
    public boolean isConnected(int a, int b) {
        return (root(a) == root(b));
    }

    @Override
    public void union(int a, int b) {
        int tempA = root(a);
        int tempB = root(b);

        /**
         * the smaller tree is merged to the larger tree.
         */
        if( weight[tempA] > weight[tempB] ) {
            connection[tempB] = tempA;
            weight[tempA] += weight[tempB];
        } else {
            connection[tempA] = tempB;
            weight[tempB] += weight[tempA];
        }

    }

    @Override
    public void print() {
        for(int i=0,n=connection.length; i<n; i++) System.out.println(i+" : "+connection[i]+" -> "+weight[i]);
    }
}
