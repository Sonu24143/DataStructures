package com.sonu.datastructures.Stacks;

import java.util.Stack;

public class BalancedParanthesis {

    public boolean isBalanced(String input, String element, String counterElement) {
        char[] tokens = input.toCharArray();
        Stack<Character> holder = new Stack<Character>();

        for(char c: tokens) {
            if(element.charAt(0) == c) {
                holder.push(c);
            } else if(counterElement.charAt(0) == c) {
                if(holder.empty()) return false;
                else holder.pop();
            }
        }
        if(holder.isEmpty()) return true;
        else return false;
    }
}
