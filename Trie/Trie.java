package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode pCrawl = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
        }
        pCrawl.isEndOfWord = true;
    }

    public boolean searchPrefix(String prefix) {
        TrieNode pCrawl = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (pCrawl.children[idx] == null) {
                return false;
            }
            pCrawl = pCrawl.children[idx];
        }
        return true;
    }
}
