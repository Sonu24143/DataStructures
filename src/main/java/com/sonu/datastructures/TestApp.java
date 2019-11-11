package com.sonu.datastructures;

public class TestApp {

    public static void main(String[] args) {
        testArray();
    }

    static void testArray(){
        Array array = new Array();
        int[][] test = { {1,2,3},{4,5,6},{7,8,9}};
        array.print(test);
        System.out.println("==============");
        array.print(array.compliment(test));
    }
}
