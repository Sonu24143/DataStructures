package com.sonu.api.implementation;

import com.sonu.api.Heap;

public class MaxHeap implements Heap {

    private int[] tree;
    private int CUR_SIZE;
    private int INCREMENT_FACTOR;
    private int CUR_POS;

    public MaxHeap(int incrementFactor) {
        tree = new int[1];
        CUR_SIZE = 1;
        CUR_POS = -1;
        INCREMENT_FACTOR = incrementFactor;
    }

    @Override
    public void add(int data) {
        int index = ++CUR_POS;
        if( index >= CUR_SIZE ) {
            int newSize = CUR_SIZE * INCREMENT_FACTOR;
            int[] tempArray = new int[newSize];
            for(int i=0; i<CUR_SIZE; i++) {
                tempArray[i] = tree[i];
            }
            tree = tempArray;
            CUR_SIZE = newSize;
        }
        tree[index] = data;
        heapifyUp(index);
    }

    @Override
    public int getRoot() {
        int rootData = tree[0];
        tree[0] = tree[CUR_POS--];
        heapifyDown(0);
        return rootData;
    }

    private void heapifyDown(int parent) {
        int lChild = leftChild(parent);
        int rChild = rightChild(parent);

        if( lChild == -1 && rChild == -1 ) {
            return;
        } else if( lChild == -1 ) {
            if( tree[parent] < tree[rChild]) {
                swap(parent, rChild);
                heapifyDown(rChild);
            }
        } else if( rChild == -1 ) {
            if( tree[parent] < tree[lChild]) {
                swap(parent, lChild);
                heapifyDown(lChild);
            }
        } else if( tree[lChild] > tree[rChild] ) {
            if( tree[parent] < tree[lChild]) {
                swap(parent, lChild);
                heapifyDown(lChild);
            }
        } else {
            if( tree[parent] < tree[rChild]) {
                swap(parent, rChild);
                heapifyDown(rChild);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    private void heapifyUp(int node) {
        int parent = getParent(node);
        if( parent >= 0 && tree[parent] < tree[node]) {
            int temp = tree[parent];
            tree[parent] = tree[node];
            tree[node] = temp;
            heapifyUp(parent);
        }
    }

    private int rightChild(int root) {
        int child = ((2*root)+1);
        if( child >= 0 && child <= CUR_POS ) return child;
        else return -1;
    }

    private int leftChild(int root) {
        int child = (2*root);
        if( child >= 0 && child <= CUR_POS ) return child;
        else return -1;
    }

    private int getParent(int node) {
        if( node == 0 ) return -1;
        return (node / 2);
    }

    private int getSize() {
        return CUR_POS+1;
    }

    public static void main(String[] args) {
        Heap heap = new MaxHeap(2);
        for(int i=10; i>=0; i--) heap.add(i);

        for(int i=0;i<11;i++) {
            System.out.print(heap.getRoot()+" -> ");
        }
    }
}
