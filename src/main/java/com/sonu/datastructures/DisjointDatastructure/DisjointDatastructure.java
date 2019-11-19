package com.sonu.datastructures.DisjointDatastructure;

import java.util.ArrayList;
import java.util.List;

public class DisjointDatastructure {
    List<Integer> connections;
    List<Integer> tags;

    public DisjointDatastructure() {
        connections = new ArrayList<>();
        tags = new ArrayList<>();
    }

    public void add(int data) {
        this.connections.add(data);
        this.tags.add(data);
    }

    public void union(int a, int b) {
        int index = this.tags.indexOf(a);
        if( index >= 0 ) {
            int temp = this.connections.get(index);
            for(int i=0,n=this.connections.size(); i<n; i++) {
                if( this.connections.get(i) == temp ) {
                    this.connections.set(i, b);
                }
            }
        }
    }

    public boolean isConnected(int a, int b) {
        if( tags.indexOf(a) == -1 || tags.indexOf(b) == -1 ) return false;
        return (this.connections.get(this.tags.indexOf(a)).equals(this.connections.get(this.tags.indexOf(b))));
    }

}
