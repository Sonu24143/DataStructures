package com.sonu.api.implementation;

import com.sonu.api.Trie;
import com.sonu.pojo.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class ArrayTrie implements Trie {

    private TrieNode root;
    private static int ARRAY_SIZE = 0;

    public ArrayTrie(int size) {
        ARRAY_SIZE = size;
        root = new TrieNode(size);
    }

    @Override
    public void add(String word) {
        char[] charArray = word.toCharArray();

        TrieNode tempRoot = root;
        int index=-1;
        for( char c: charArray ) {
            index = Trie.getIndex(c);
            if( tempRoot.children[index] == null ) {
                //initalize a new trie node and add here
                TrieNode temp = new TrieNode(ARRAY_SIZE);
                tempRoot.children[index] = temp;
                tempRoot = temp;
            } else {
                tempRoot = tempRoot.children[index];
            }
        }
        tempRoot.endWord[index] = true;
    }

    @Override
    public boolean exists(String word) {
        char[] charArray = word.toCharArray();
        TrieNode tempRoot = root;

        int index=-1;
        for(char c: charArray) {
            index = Trie.getIndex(c);
            if( tempRoot.children[index] == null ) {
                return false;
            } else {
                tempRoot = tempRoot.children[index];
            }
        }
        return (tempRoot.endWord[index]);
    }

    public List<String> getPossibleWords(String prefix) {
        TrieNode subRoot = getSubRoot(prefix);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        getList(subRoot, sb, result);
        return result;
    }

    private void getList(TrieNode curNode, StringBuilder sb, List<String> words) {
        if( curNode == null ) return;

        for(int i=0; i<ARRAY_SIZE; i++) {
            char c = Trie.getChar(i);

            if( curNode.children[i] != null ) {
                sb.append(c);
                if( curNode.endWord[i] ) {
                    words.add(sb.toString());
                }
                getList(curNode.children[i], sb, words);
                sb.deleteCharAt(sb.length()-1);
            } else {
                if( curNode.endWord[i] ) {
                    words.add(sb.toString());
                }
            }
        }
    }

    private TrieNode getSubRoot(String prefix) {
        TrieNode tempRoot = root;
        char[] charArray = prefix.toCharArray();
        for(char c: charArray) {
            int index = Trie.getIndex(c);
            if( tempRoot.children[index] == null ) {
                return null;
            } else {
                tempRoot = tempRoot.children[index];
            }
        }
        return tempRoot;
    }

    public static void main(String[] args) {
        Trie trie = new ArrayTrie(26);
        trie.add("MA");
        trie.add("MAN");
        trie.add("MANY");
        trie.add("MAM");
        trie.add("MAID");
        List<String> result = ((ArrayTrie) trie).getPossibleWords("M");
        result.forEach(System.out::println);
    }
}
