package com.sonu.datastructures.api.implementation;

import com.sonu.datastructures.api.UnionSet;

public class UnionTreeSet implements UnionSet {
    private int[] connection;

    public UnionTreeSet(int n) {
        connection = new int[n];
        for(int i=0; i<n; i++) connection[i] = i;
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
        connection[a] = root(b);
    }

    @Override
    public void print() {
        for(int i=0,n=connection.length; i<n; i++) System.out.println(i+" : "+connection[i]);
    }
}
