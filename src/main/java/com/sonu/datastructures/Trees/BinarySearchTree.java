package com.sonu.datastructures.Trees;

public class BinarySearchTree {
    private Node root = null;


    public Node getRoot() {
        return root;
    }

    public void add(Integer data) {
        Node temp = root;
        Node newNode = new Node();

        newNode.data = data;
        if( root == null ) {
            root = newNode;
            return;
        }
        while (temp != null) {
            if( data > temp.data){
                if(temp.rightChild == null) {
                    temp.rightChild = newNode;
                    return;
                }
                temp = temp.rightChild;
            } else if( data < temp.data) {
                if(temp.leftChild == null) {
                    temp.leftChild = newNode;
                    return;
                }
                temp = temp.leftChild;
            } else {
                return;
            }
        }

    }

    private Node findSuccessor(Node start) {
        if( start.leftChild == null ) {
            return start;
        } else if( start.leftChild.leftChild == null ) {
            Node temp = start.leftChild;
            start.leftChild = null;
            return temp;
        } else {
            return findSuccessor(start.leftChild);
        }
    }

    public void remove(Integer data) {
        Node temp = root;

        while (temp != null) {
            if(temp.data.equals(data)) {
                if( temp.rightChild == null ) {
                    temp = temp.leftChild;
                } else {
                    Node successor = findSuccessor(temp.rightChild);
                    if( successor == temp.rightChild ) {
                        temp.data = successor.data;
                        temp.rightChild = successor.rightChild;
                    } else {
                        temp.data = successor.data;
                    }
                }
            } else if( data < temp.data ) {
                temp = temp.leftChild;
            } else {
                temp = temp.rightChild;
            }
        }
    }

    public void print(Node cur) {
        if( cur == null ) return;
        print(cur.leftChild);
        System.out.print(cur.data+" -> ");
        print(cur.rightChild);
    }

    public int maxDepth(Node n) {
        if(n==null) return 0;

        int leftDepth = maxDepth(n.leftChild);
        int rightDepth = maxDepth(n.rightChild);

        if( leftDepth > rightDepth) return leftDepth+1;
        else return rightDepth+1;
    }

    private int diameter = 0;

    public int getDiameter() {
        return diameter;
    }

    public void getDiameter(Node node) {
        if( node == null ) return;

        int lDepth = maxDepth(node.leftChild);
        int rDepth = maxDepth(node.rightChild);
        int distance = lDepth + rDepth + 1;
        if( distance > diameter ) diameter = distance;

        getDiameter(node.leftChild);
        getDiameter(node.rightChild);
    }

    public Node find(Node node, int n) {
        if( node == null ) return null;

        if( n < node.data ) {
          return find(node.leftChild, n);
        } else if( n > node.data ) {
            return find(node.rightChild, n);
        } else {
            return node;
        }
    }
}

class Node {
    public Integer data = null;
    public Node rightChild = null;
    public Node leftChild = null;
}
