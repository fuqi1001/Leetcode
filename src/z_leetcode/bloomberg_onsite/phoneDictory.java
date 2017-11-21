package z_leetcode.bloomberg_onsite;


import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> child;
    boolean isLast;
    public TrieNode() {
        child = new HashMap<>();
        for(char i = 'a'; i <= 'z'; i++) {
            child.put(i, null);
        }
        isLast = false;
    }
}
public class phoneDictory {
    TrieNode root;
    public void insertToTrie(String[] contacts) {
        root = new TrieNode();
        for(String cur : contacts) {
            insert(cur);
        }
    }
    public void insert(String s) {
        int len = s.length();
        TrieNode itr = root;
        for(int i = 0; i < len; i++) {
            TrieNode nextNode = itr.child.get(i);
            if(nextNode == null) {
                nextNode = new TrieNode();
                itr.child.put(s.charAt(i), nextNode);
            }
            itr = nextNode;
            if(i == len - 1) itr.isLast = true;
        }
    }

    public void showContactUtil(TrieNode curNode, String prefix) {
        if(curNode.isLast) System.out.println(prefix);
        for(char i = 'a' ; i <= 'z'; i++) {
            TrieNode nextNode = curNode.child.get(i);
            if(nextNode != null) {
                showContactUtil(nextNode, prefix + i);
            }
        }
    }

    public void showContact(String str) {
        TrieNode prevNode = root;
        String prefix = "";
        int len = str.length();
        int i;
        for(i = 0; i < len; i++) {
            prefix += str.charAt(i);
            char lastChar = prefix.charAt(i);
            TrieNode curNode = prevNode.child.get(lastChar);

            if(curNode == null) {
                System.out.println("No result for " + prefix);
                i++;
                break;
            }
            System.out.println("Suggestions based on " + prefix +" are");
            showContactUtil(curNode, prefix);
            prevNode = curNode;
        }

        for(; i < len; i++) {
            prefix += str.charAt(i);
            System.out.println("No result for " + prefix);
        }
    }
}
