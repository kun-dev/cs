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