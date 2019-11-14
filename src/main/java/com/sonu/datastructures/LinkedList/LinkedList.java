package com.sonu.datastructures.LinkedList;

public class LinkedList<T> {
    private Node root = new Node();
    private Node lastNode = root;

    public void add(T data) {

            Node cur = new Node();
            cur.data = data;
            cur.next = null;
            lastNode.next = cur;
            lastNode = cur;

    }

    public boolean remove(T data) {
        boolean removed = false;
        Node temp = root;
        do {
            Node cur = temp.next;
            if(cur != null && cur.data.equals(data)) {
                temp.next = cur.next;
                removed = true;
                continue;
            }
            temp = temp.next;
        } while (temp != null);
        return removed;
    }

    public void print() {
        Node temp = root.next;
        while (temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("X");
    }

    public boolean isEmpty() {
        return root.next == null;
    }
}

class Node<T> {
    public Node next = null;
    public T data = null;

}
