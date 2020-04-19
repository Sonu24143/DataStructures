package com.sonu.datastructures.api.implementation;

import com.sonu.datastructures.api.UnionSet;

public class UnionArraySet implements UnionSet {
    private int[] connection;

    public UnionArraySet(int n) {
        connection = new int[n];
        for(int i=0; i<n; i++) connection[i] = i;
    }

    @Override
    public boolean isConnected(int a, int b) {
        return (connection[a] == connection[b]);
    }

    @Override
    public void union(int a, int b) {
        int sourceA = connection[a];
        int sourceB = connection[b];

        for(int i=0,n=connection.length; i<n; i++) {
            if( connection[i] == sourceA ) connection[i] = sourceB;
        }
    }

    @Override
    public void print() {
        for(int i=0,n=connection.length; i<n; i++) System.out.println(i+" : "+connection[i]);
    }
}
