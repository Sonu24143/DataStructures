package com.sonu.datastructures;

import com.sonu.datastructures.Arrays.Array;
import com.sonu.datastructures.DisjointDatastructure.DisjointDatastructure;
import com.sonu.datastructures.Heap.Heap;
import com.sonu.datastructures.Heap.PriorityQueue;
import com.sonu.datastructures.LinkedList.LinkedList;
import com.sonu.datastructures.Queues.RotateString;
import com.sonu.datastructures.SegmentTree.SegmentTree;
import com.sonu.datastructures.Stacks.BalancedParanthesis;
import com.sonu.datastructures.Trees.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestApp {

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            testDisjointSet();
        } finally {
            br.close();
        }

    }

    static void testDisjointSet() {
        DisjointDatastructure dds = new DisjointDatastructure();
        for(int i=1; i<11; i++) {
            dds.add(i*2);
        }
        dds.union(2,6);
        System.out.println("2 -> 5"+dds.isConnected(2,5));
        dds.union(6,8);
        dds.union(6,10);
        System.out.println("8 -> 10: "+dds.isConnected(8,10));
    }

    static void testSegmentTree() {
        List<Integer> input = new ArrayList<>();
        for (int i=0; i<10; i++) input.add(i);
        SegmentTree st = new SegmentTree(input);
        st.build();
        st.print();
        System.out.println("2->4: "+st.query(2,4));
        System.out.println("4->7: "+st.query(4,7));
    }

    static void testPriorityQueue() {
        PriorityQueue pq = new PriorityQueue(true);
        for(int i=1; i<10; i++) pq.add(i);
        pq.print();
        for(int i=1; i<10; i++) {
            System.out.println("\nRemoved element: "+ pq.remove());
            pq.print();
        }
    }

    static void testHeap() {
        Heap h = new Heap();
        h.add(4);
        h.add(2);
        h.add(6);
        h.add(3);
        h.add(1);
        h.add(5);
        h.add(7);
        h.add(9);
        h.add(8);
        h.print();
        System.out.println("\nMax heap: ");
        h.buildHeap(true);
        h.print();
        System.out.println("\nMin heap: ");
        h.buildHeap(false);
        h.print();
        System.out.println("\nRemoving smallest element.");
        h.remove();
        h.buildHeap(false);
        h.print();
        System.out.println("\nRemoving smallest element.");
        h.remove();
        h.buildHeap(false);
        h.print();
        System.out.println("\nadding 1 and 2");
        h.add(1);
        h.add(2);
        System.out.println("\nMax heap");
        h.buildHeap(true);
        h.print();
        System.out.println("\nRemoving largest element");
        h.remove();
        h.print();
        h.buildHeap(true);
        System.out.println("\nRemoving largest element");
        h.remove();
        h.buildHeap(true);
        h.print();

    }

    static void testBinaryTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(4);
        bst.add(2);
        bst.add(6);
        bst.add(3);
        bst.add(1);
        bst.add(5);
        bst.add(7);
        bst.add(8);
        bst.add(9);
        bst.print(bst.getRoot());
        System.out.println("\nMax depth: "+bst.maxDepth(bst.getRoot()));
        bst.getDiameter(bst.getRoot());
        System.out.println("Diameter: "+bst.getDiameter());
        System.out.println("Subtree of 6");
        bst.print(bst.find(bst.getRoot(), 6));
    }

    static void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1; i<=9; i++) list.add(i);
        list.print();
        list.remove(5);
        list.print();
        list.add(5);
        list.print();
    }

    static void rotateString() {
        String test = "Sonu Jose Parekaden";
        RotateString rs = new RotateString();
        System.out.println(test);
        System.out.println("=========");
        System.out.println(rs.rotate(test, 4));
    }

    static void balancedParanthesis() {
        String testFail = "{{{{}}{{}{}{}{}{}{}}}}}{";
        String testSuccess = "{{{{{}}}}}{{{}}{}}";
        BalancedParanthesis bp = new BalancedParanthesis();
        System.out.println(bp.isBalanced(testFail, "{", "}"));
        System.out.println(bp.isBalanced(testSuccess, "{", "}"));
    }

    static void testArray(){
        Array array = new Array();
        int[][] test = { {1,2,3},{4,5,6},{7,8,9}};
        array.print(test);
        System.out.println("==============");
        array.print(array.compliment(test));
    }
}
