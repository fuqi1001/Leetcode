package leetcode.Implement;

/**
 * Created by qifu on 17/2/15.
 */
public class AddandSearchWord {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chr, int k, TrieNode node){
        if(k == chr.length){
            return node.isWord;
        }
        if(chr[k] == '.'){
            for(int i = 0; i < node.children.length; i++){
                if(node.children[i] != null && match(chr, k + 1, node.children[i])) return true;
            }
        } else {
            return node.children[chr[k] - 'a'] != null && match(chr, k + 1, node.children[chr[k] - 'a']);
        }
        return false;
    }

    /*
    字典树存储,碰到'.'就往下一层寻找 如果找到返回true

     */
}
