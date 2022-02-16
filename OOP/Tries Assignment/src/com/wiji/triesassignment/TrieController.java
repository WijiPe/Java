package com.wiji.triesassignment;

public class TrieController {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        
//        System.out.println(trie.isPrefixValid("cs"));
//        System.out.println(trie.isPrefixValid("ca"));
//        System.out.println(trie.isWordValid("car"));
//        System.out.println(trie.isWordValid("cas"));
        trie.printAllKeys();
    }
}
