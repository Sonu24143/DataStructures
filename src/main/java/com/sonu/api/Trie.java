package com.sonu.api;

public interface Trie {

    public void add(String word);

    public boolean exists(String word);

    public static int getIndex(char c) {
        if( (int) c > 96 ) {
            int temp = ((int)c - 97);
            return temp;
        }
        return ( ( (int) c) - 65);
    }

    public static char getChar(int index) {
        return ((char) (65+index));
    }
}
