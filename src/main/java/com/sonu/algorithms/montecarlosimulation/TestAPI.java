package com.sonu.algorithms.montecarlosimulation;

public class TestAPI {

    private static Node reverseRoot = null;

    public static void main(String[] args) {
        Node root = createList();
        printList(root);
        System.out.println();
        /*Node tail = reverseListIterative(root);
        tail.next = null;
        printList(reverseRoot)*/;
        printList(reverseListIterative(root));
    }

    static Node reverseListIterative(Node root) {
        if( root == null ) return null;
        Node t1 = root;
        Node t2 = root.next;
        t1.next = null;

        while ( t2 != null ) {
            Node temp = t2;
            t2 = t2.next;
            temp.next = t1;
            t1 = temp;
        }
        return t1;
    }

    static Node reverseList(Node root) {
        if( root.next != null ) {
            Node cur = reverseList(root.next);
            cur.next = root;
        }
        if( reverseRoot == null ) reverseRoot = root;
        return root;
    }

    public static void printList(Node root) {
        if( root != null ) {
            System.out.print(root.data+" -> ");
            printList(root.next);
        }
    }

    public static Node createList() {
        Node root = new Node();
        root.data = 1;
        Node head  = root;

        for(int i=2; i<=5; i++) {
            Node temp = new Node();
            temp.data = i;
            temp.next = null;
            root.next = temp;
            root = temp;
        }
        return head;
    }
}

class Node {
    public int data;
    public Node next;
}
