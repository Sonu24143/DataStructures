package com.sonu.datastructures;

import com.sonu.datastructures.Arrays.Array;
import com.sonu.datastructures.Heap.Heap;
import com.sonu.datastructures.LinkedList.LinkedList;
import com.sonu.datastructures.Queues.RotateString;
import com.sonu.datastructures.Stacks.BalancedParanthesis;
import com.sonu.datastructures.Trees.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestApp {

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            testHeap();
        } finally {
            br.close();
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
