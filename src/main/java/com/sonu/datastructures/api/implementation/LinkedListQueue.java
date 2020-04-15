package com.sonu.datastructures.api.implementation;

import com.sonu.datastructures.api.Queue;
import com.sonu.pojo.QueueNode;

public class LinkedListQueue<T> implements Queue<T> {
    private QueueNode<T> head = null;
    private QueueNode<T> tail = null;

    @Override
    public void push(T data) {
        QueueNode<T> queueNode = new QueueNode<>();
        queueNode.data = data;
        queueNode.next = null;

        if( head == null ) head = queueNode;
        if( tail == null ) {
            tail = queueNode;
        } else {
            tail.next = queueNode;
            tail = queueNode;
        }
    }

    @Override
    public T pop() {
        if( head == null ) {
            tail = null;
            return null;
        }
        T data = (T) head.data;
        head = head.next;
        return data;
    }

    @Override
    public T peek() {
        return (head == null) ? null : head.data;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        for(int i=0;i<10;i++) queue.push(i);
        while (! queue.isEmpty()) {
            System.out.println("Element: "+queue.peek());
            queue.pop();
        }
    }
}
