package com.sonu.datastructures.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class RotateString {

    public String rotate(String input, int n) {
        Queue<Character> holder = new LinkedList<Character>();
        char[] tokens = input.toCharArray();
        for (char c: tokens) holder.add(c);
        for(int i=0; i<n; i++) {
            char temp = ((LinkedList<Character>) holder).removeLast();
            ((LinkedList<Character>) holder).add(0, temp);
        }
        StringBuilder result = new StringBuilder();
        while ( ! holder.isEmpty() ) {
            result.append(((LinkedList<Character>) holder).removeFirst());
        }
        return result.toString();
    }

}
