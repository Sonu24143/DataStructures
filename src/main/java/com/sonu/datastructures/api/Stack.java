package com.sonu.datastructures.api;

public interface Stack<T> {

    public void push(T data);

    public T pop();

    public T peek();

    public boolean isEmpty();
}
