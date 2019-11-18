package com.sonu.datastructures.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
    private List<Integer> elements = new ArrayList<Integer>();

    public Heap() {
        elements.add(Integer.MIN_VALUE);
    }

    public void add(int data) {
        elements.add(data);
    }

    public void buildHeap(boolean isMaxHeap) {
        for(int i=(getSize())/2; i>=1; i-- ) {
            if(isMaxHeap) maxHeapify(i);
            else minHeapify(i);
        }
    }

    public void maxHeapify(int index) {
        int leftChild = 2*index;
        int rightChild = (2*index)+1;
        int largest = index;
        if( leftChild <= getSize() && elements.get(leftChild) > elements.get(largest)) {
            largest = leftChild;
        }

        if( rightChild <= getSize() && elements.get(rightChild) > elements.get(largest)) {
            largest = rightChild;
        }
        if( largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    public void minHeapify(int index) {
        int leftChild = 2*index;
        int rightChild = (2*index)+1;
        int smallest = index;
        if( leftChild <= getSize() && elements.get(leftChild) < elements.get(smallest)) {
            smallest = leftChild;
        }

        if( rightChild <= getSize() && elements.get(rightChild) < elements.get(smallest)) {
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

    public int getSize() {
        return elements.size()-1;
    }

    public Integer remove(){
        if(getSize()>=1) {
        int e = elements.get(1);
        elements.remove(1);
        return e;
    } else {
            return null;
        }
    }

    public void print() {
        for(int i=1,n=getSize(); i<=n; i++) System.out.print(elements.get(i)+" -> ");
    }
}
