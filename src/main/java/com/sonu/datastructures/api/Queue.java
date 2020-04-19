package com.sonu.datastructures.api;

public interface Queue<T> {

    public void push(T data);

    public T pop();

    public T peek();

    public boolean isEmpty();
}
