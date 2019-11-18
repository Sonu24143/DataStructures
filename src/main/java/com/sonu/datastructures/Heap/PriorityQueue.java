package com.sonu.datastructures.Heap;

public class PriorityQueue {
    Heap heap = null;
    boolean isMaxHeap;

    public PriorityQueue(boolean isMaxHeap) {
        heap = new Heap();
        this.isMaxHeap = isMaxHeap;
    }

    public void add(int data) {
        heap.add(data);
        int indexAdded = heap.getSize();
        while ( indexAdded > 1) {
            indexAdded = Math.floorDiv(indexAdded, 2);
            if( indexAdded < 1) break;
            if(isMaxHeap) heap.maxHeapify(indexAdded);
            else heap.minHeapify(indexAdded);
        }
        if(isMaxHeap) heap.maxHeapify(1);
        else  heap.minHeapify(1);
    }

    public Integer remove() {
        Integer e = heap.remove();
        if( isMaxHeap ) heap.maxHeapify(1);
        else heap.minHeapify(1);
        return e;
    }

    public void print() {
        heap.print();
    }
}
