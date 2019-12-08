# Tries (Prefix Trees)

A tries (sometimes called a prefix tree) is a data structure. It comes up a lot in interview questions, but algorithm textbooks don't spend much time on this data structure.

A trie is a variant of an n-ary tree in which characters are stored at each node. Each path down the tree may represent a word.

The * nodes (sometimes called "null nodes") are often used to indicate complete words. For example, the fact that there is a * node under MANY indicates that MANY is a complete word. The existence of the MA path indicates there are words that start with MA.

![Trie Image!](image/tries.jpg "Tries")

Very commonly, a trie is used to store the entire (English) language for quick prefix lookups. While a hash table can quickly look up whether a string is a valid word, it cannot tell us if a string is a prefix of any valid words. A trie can do this quickly.

> How quickly? A trie can check if a string is a valid prefix in O(k) time, where k is the length of the string. This is actually the same runtime as a hash table will take. Although we often refer to hash table lookups as being O(1) time, this isn't entirely true. A hash table must read through all characters in the input, which takes O(k) time in the case of a word lookup.

Many problems involving lists of valid words leverage a trie as an optimization. In situations when we search through the tree on related prefixs repeatedly (e.g., looking up M, then MA, then MAN, then MANY), we might pass around a reference to the current node in the tree. This will allow us to just check if Y is a child of MAN. Rather than starting from the root search each time.

## Trie Node
```java
public class Trie {
    private char c;
    private HashMap<Character, Trie> children = new HashMap<Character, Trie>();
    private boolean isLeaf;

    public Trie() {}

    public Trie(char c) {
        this.c = c;
    }

    public HashMap<Character, Trie> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, Trie> childeren) {
        this.children = childeren;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
```
## Test Code
```java
public class TrieTest {
    public static void insert(String word, Trie root) {
        HashMap<Character, Trie> children = root.getChildren();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie node;
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new Trie(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if (i == word.length() - 1) {
                node.setLeaf(true);
            }
        }
    }

    public boolean search(String word, Trie root) {
        HashMap<Character, Trie> cihldren = root.getChildren();
        Trie node = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else {
                node = null;
                break;
            }

            if (node != null && node.isLeaf()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
```