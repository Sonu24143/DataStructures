package com.sonu.pojo;

public class TrieNode {
    public boolean[] endWord;
    public TrieNode[] children;

    public TrieNode(int size){
        children = new TrieNode[size];
        endWord = new boolean[size];
    }
}
