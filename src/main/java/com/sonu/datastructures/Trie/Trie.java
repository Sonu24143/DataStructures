package com.sonu.datastructures.Trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Trie {
    TrieNode root = null;
    private static final String WORD_PATTERN = "^[a-zA-Z]*";
    private Pattern pattern = Pattern.compile(WORD_PATTERN);
    private long counter = 0L;

    public void insert(String data) {
        if( ! pattern.matcher(data).matches() ) return;
        counter++;
        data=data.toLowerCase();
        if(root == null) root = new TrieNode();
        crawl(this.root, data);
    }

    public boolean search(String data) {
        return find(this.root, data);
    }

    private boolean find(TrieNode node, String input) {
        if( node == null) return false;
        int index = getIndex(input.charAt(0));

        if( input.length() == 1) {
            return ( node.list[index] != null && node.isEndOfWord);
        } else {
            return (node.list[index] != null && find(node.list[index], input.substring(1)));
        }
    }

    private void crawl(TrieNode node, String input) {
        int index = getIndex(input.charAt(0));

        if( node.list[index] != null ) {
            if(input.length() > 1 ) crawl(node.list[index], input.substring(1));
            else node.isEndOfWord = true;
        } else {
            TrieNode newNode = new TrieNode();
            node.list[index] = newNode;
            if(input.length() > 1 ) crawl(node.list[index], input.substring(1));
            else node.isEndOfWord = true;
        }
    }

    private int getIndex(char c) {
        int index = (int)c - 97;
        return (index);
    }

    public static void main(String[] args) throws IOException {
        Trie trie = new Trie();
        BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
        String s;
        long start = System.currentTimeMillis();
        while ((s=br.readLine()) != null) trie.insert(s.trim());
        System.out.println("Trie processed in : "+(System.currentTimeMillis() - start)+"ms, words: "+trie.counter);
        System.out.println("wood: "+trie.search("wood"));
        System.out.println("notaword: "+trie.search("notaword"));
    }
}

class TrieNode {
    private static final int MAX_SIZE = 26;
    public TrieNode[] list;
    public boolean isEndOfWord = false;

    public TrieNode() {
        list = new TrieNode[MAX_SIZE];
    }
}
