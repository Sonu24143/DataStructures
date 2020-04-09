package com.sonu.algorithms.montecarlosimulation;

import com.sonu.datastructures.api.UnionSet;
import com.sonu.datastructures.api.implementation.UnionArraySet;

public class SystemPercolationThresholdFinder {

    public static void main(String[] args) {
        UnionSet unionSet = new UnionArraySet(10);

        unionSet.union(1,2);
        unionSet.union(3,4);
        unionSet.union(5,6);
        unionSet.union(7,8);
        unionSet.union(7,9);
        unionSet.union(0,5);
        unionSet.union(8,2);
        unionSet.union(1,0);
        unionSet.union(9,1);

        System.out.println(unionSet.isConnected(1,9));
    }
}
