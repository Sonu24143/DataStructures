package com.sonu;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args)  {

        A a = new A("1");
        a.run();
    }
}

class A implements Runnable{
    public void method() {
        System.out.println("A");
    }
String name;
    public A(String name) { this.name = name;}
    @Override
    public void run() {
        System.out.println(this.name);
    }
}

