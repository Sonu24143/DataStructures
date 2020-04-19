package com.sonu.datastructures.api.implementation;

import com.sonu.datastructures.api.Stack;
import com.sonu.pojo.StackNode;

public class LinkedListStack<T> implements Stack<T> {
    StackNode top = null;

    @Override
    public void push(T data) {
        StackNode<T> stackNode = new StackNode<>();
        stackNode.data = data;
        stackNode.prev = top;
        top = stackNode;
    }

    @Override
    public T pop() {
        if( top == null ) return null;
        T data = (T) top.data;
        top = top.prev;
        return data;
    }

    @Override
    public T peek() {
        return (T)top.data;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    public static void main(String[] args) {
       Stack<Integer> stack = new LinkedListStack<>();
       for(int i=0;i<10;i++) stack.push(i);
       while ( ! stack.isEmpty() ) {
           System.out.println("Element: "+stack.peek());
           stack.pop();
       }
    }
}
