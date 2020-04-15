package com.sonu.algorithms.montecarlosimulation;

import com.sonu.datastructures.api.UnionSet;
import com.sonu.datastructures.api.implementation.UnionWeightedTreeSet;

import java.util.Arrays;
import java.util.Random;

public class PercolationThreshold {
    private UnionSet unionSet;
    private boolean[] systemState;
    private int n;
    private int dimension;

    public PercolationThreshold(int size) {
        n = size * size;
        dimension = size;
        unionSet = new UnionWeightedTreeSet(n);
        systemState = new boolean[n];
        for(int i=0; i<n; i++) systemState[i] = false;
    }

    public double getThreshold() {

        double temp;

        while (true) {
            int pos = getPosoitiontoOpen();
            if( systemState[pos] ) continue;
            //System.out.println("opening pos:"+pos);
            int index = up(pos);
            if( index != -1) {
                if( ! unionSet.isConnected(pos,index) ) {
                    unionSet.union(pos,index);
                    systemState[pos] = true;
                }
            }
            index = down(pos);
            if( index != -1) {
                if( ! unionSet.isConnected(pos,index) ) {
                    unionSet.union(pos,index);
                    systemState[pos] = true;
                }
            }
            index = left(pos);
            if( index != -1) {
                if( ! unionSet.isConnected(pos,index) ) {
                    unionSet.union(pos,index);
                    systemState[pos] = true;
                }
            }
            index = right(pos);
            if( index != -1) {
                if( ! unionSet.isConnected(pos,index) ) {
                    unionSet.union(pos,index);
                    systemState[pos] = true;
                }
            }
            systemState[pos] = true;

            if( canPercolate() ) {
                double openCount=0;
                for(boolean b: systemState) {
                    if(b) openCount++;
                }
                return (openCount/(double)n);
            }
        }
    }

    private void printState() {
        for(int i=0;i<dimension;i++) {
            for(int j=0;j<dimension;j++) {
                System.out.print(systemState[i+j]+"-");
            }
            System.out.println();
        }
    }

    private boolean canPercolate() {
        for(int i=0;i<dimension;i++) {
            for(int j=n-dimension;j<n;j++) {

                if( systemState[i] && systemState[n-j] && unionSet.isConnected(i,j)) return true;
            }
        }
        return false;
    }

    private int getPosoitiontoOpen() {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(n);
    }

    private int up(int pos) {
        int upIndex = pos - dimension;
        if( ( upIndex > 0 ) && systemState[upIndex]) return upIndex;
        return -1;
    }

    private int down(int pos) {
        int downIndex = pos + dimension;
        if( downIndex < n && systemState[downIndex]) return downIndex;
        return -1;
    }

    private int left(int pos) {
        if( pos % dimension == 0 ) return -1;
        int leftIndex = pos - 1;
        if(systemState[leftIndex]) return leftIndex;
        return -1;
    }

    private int right(int pos) {
        if( (pos+1) % dimension == 0 ) return -1;
        int rightIndex = pos + 1;
        if(systemState[rightIndex]) return rightIndex;
        return -1;
    }

    /**
     * Test method
     * @param args
     */
    public static void main(String[] args) {
        int testSize=20;
        double[] result = new double[testSize];
        long start = System.currentTimeMillis();

        for(int i=0;i<testSize;i++) {
            PercolationThreshold pt = new PercolationThreshold(50);
            result[i] = pt.getThreshold();
            System.out.println("Result["+i+"] = "+result[i]);
        }
        double threshold = Arrays.stream(result).sum() / testSize;
        System.out.println("Threshold found after: "+testSize+", is: "+threshold+".\nTime taken for test: "+(System.currentTimeMillis()-start)+" ms.");
    }
}
