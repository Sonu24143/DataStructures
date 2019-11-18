package com.sonu.datastructures.SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class SegmentTree {
    int[] input;
    int[] segmmetArray;

    public SegmentTree(List<Integer> input) {
        int inputSize = input.size();
        this.input = new int[inputSize];
        for(int i=0; i<inputSize; i++) this.input[i] = input.get(i);

        // determine and set the size of the segment array to be represented as a tree
        double logValue = 31 - Integer.numberOfLeadingZeros(inputSize*2);
        if( inputSize != (Math.pow(2, logValue))){
            this.segmmetArray = new int[(int)Math.pow(2, logValue+1)];
        } else {
            this.segmmetArray = new int[(int)logValue];
        }
    }

    public void print() {
        System.out.println("\n======INPUT========");
        for(int i=0,n=input.length; i<n; i++) {
            System.out.print(input[i]);
            if( i != n-1) System.out.print("->");
        }
        System.out.println("\n=====SEGMENT TREE=======");
        for(int i=0,n=segmmetArray.length; i<n; i++) {
            System.out.print(segmmetArray[i]);
            if( i != n-1) System.out.print("->");
        }
        System.out.println();
    }

    public void build() {
        construct(0, input.length-1, 0);
    }

    private void construct(int low, int high, int pos) {

        if( high == low ) {
            segmmetArray[pos] = input[low];
            return;
        }
        int mid = ( low + high ) / 2;
        int leftChildIndex = (2*pos) + 1;
        int rightChildIndex = (2*pos) + 2;
        construct(low, mid, leftChildIndex);
        construct(mid+1, high, rightChildIndex);
        segmmetArray[pos] = operation(segmmetArray[leftChildIndex], segmmetArray[rightChildIndex]);
    }

    private int operation(int a, int b) {
        return (a+b);
    }

    public int query(int left, int right) {
        return processQuery(left, right, 0, input.length-1, 0);
    }

    private int processQuery(int queryLeft, int queryRight, int low, int high, int pos) {

        if( low == high && queryLeft <= low && queryRight >= low){
            // reached terminal node and the range is withing queried range
            return segmmetArray[pos];
        }

        if( queryLeft == low && queryRight == high ) {
            // perfect overlap
            return segmmetArray[pos];
        }

        if( queryRight < low || queryLeft > high ) {
            // No overlap
            return Integer.MIN_VALUE;
        }

        int mid = (low+high)/2;
        // Look at the left and right
        int leftValue = processQuery(queryLeft, queryRight, low, mid, (2*pos)+1);
        int rightValue = processQuery(queryLeft, queryRight, mid+1, high, (2*pos)+2);
        if( leftValue == Integer.MIN_VALUE ) return rightValue;
        else if ( rightValue == Integer.MIN_VALUE ) return leftValue;
        else return operation(leftValue, rightValue);

    }

}
