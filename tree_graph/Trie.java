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