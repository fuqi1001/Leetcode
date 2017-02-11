package leetcode.Implement;

/**
 * Created by qifu on 17/2/11.
 */
class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(){};

}
public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
/// hash
class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isWord;
    public TrieNode(){};
    public TrieNode(char c){
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curChildren.containsKey(c)){
                cur = curChildren.get(c);
            } else {
                TrieNode newNode = new TrieNode(c);
                curChildren.put(c, newNode);
                cur = newNode;
            }

            curChildren = cur.children;
            if(i == word.length()-1){
                cur.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(searchHelper(word) == null) return false;
        else if(searchHelper(word).isWord){
            return true;

        }
        else
            return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(searchHelper(prefix) == null) return false;
        else return true;
    }

    private TrieNode searchHelper(String s){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        for(int i = 0 ;i < s.length(); i++){
            char c = s.charAt(i);
            if(children.containsKey(c)){
                cur = children.get(c);
                children = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }
}
