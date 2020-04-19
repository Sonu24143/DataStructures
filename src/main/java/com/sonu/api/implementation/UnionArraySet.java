package com.sonu.api.implementation;

import com.sonu.api.UnionSet;

public class UnionArraySet implements UnionSet {
    private int[] connections;

    public UnionArraySet(int n) {
        connections = new int[n];
        for(int i=0; i<n; i++) connections[i] = i;
    }

    @Override
    public boolean isConnected(int a, int b) {
        return (connections[a] == connections[b]);
    }

    @Override
    public boolean union(int a, int b) {
        return false;
    }
}
