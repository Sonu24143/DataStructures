package com.sonu.datastructures.Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> elements = new ArrayList<Integer>();

    public void add(int data) {
        elements.add(data);
    }

    public void buildHeap(boolean isMaxHeap) {
        for(int i=(elements.size()-1)/2; i>=0; i-- ) {
            if(isMaxHeap) maxHeapify(i);
            else minHeapify(i);
        }
    }

    private void maxHeapify(int index) {
        int leftChild = 2*index;
        int rightChild = (2*index)+1;
        int largest = index;
        if( leftChild < elements.size() && elements.get(leftChild) > elements.get(largest)) {
            largest = leftChild;
        }

        if( rightChild < elements.size() && elements.get(rightChild) > elements.get(largest)) {
            largest = rightChild;
        }
        if( largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    private void minHeapify(int index) {
        int leftChild = 2*index;
        int rightChild = (2*index)+1;
        int smallest = index;
        if( leftChild < elements.size() && elements.get(leftChild) < elements.get(smallest)) {
            smallest = leftChild;
        }

        if( rightChild < elements.size() && elements.get(rightChild) < elements.get(smallest)) {
            smallest = rightChild;
        }
        if( smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int index1, int index2) {
        int temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }

    public void remove(){ elements.remove(0);}

    public void print() {
        for(int i=0,n=elements.size(); i<n; i++) System.out.print(elements.get(i)+" -> ");
    }
}
