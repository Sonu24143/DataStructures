package com.sonu.algorithms.montecarlosimulation;

import com.sonu.datastructures.api.UnionSet;
import com.sonu.datastructures.api.implementation.UnionArraySet;
import com.sonu.datastructures.api.implementation.UnionTreeSet;
import com.sonu.datastructures.api.implementation.UnionWeightedTreeSet;

import java.util.Arrays;

public class TestAPI {

    public static void main(String[] args) {
        /*UnionSet unionSet = new UnionWeightedTreeSet(10);

        unionSet.union(1,2);
        unionSet.union(3,4);
        unionSet.union(5,6);
        unionSet.union(7,8);
        unionSet.union(7,9);
        unionSet.union(0,5);
        unionSet.union(8,2);
        unionSet.union(9,1);

        System.out.println(unionSet.isConnected(1,9));
        System.out.println(unionSet.isConnected(5,7));
        //unionSet.print();*/
        int testSize=10000;
        PercolationThreshold pt = new PercolationThreshold(1000);
        double[] result = new double[testSize];
        long start = System.currentTimeMillis();
        for(int i=0;i<testSize;i++) {
            result[i] = pt.getThreshold();
            //System.out.println("Result["+i+"] = "+result[i]);
        }
        double threshold = Arrays.stream(result).sum() / testSize;
        System.out.println("Threshold found after: "+testSize+", is: "+threshold+".\nTime taken for test: "+(System.currentTimeMillis()-start)+" ms.");
    }
}
