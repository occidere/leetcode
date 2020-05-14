class Trie {
    final private Trie[] children = new Trie[26];
    private boolean isLeaf;

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, 0);
    }

    private void insert(String word, int idx) {
        if (idx < word.length()) {
            int childIdx = word.charAt(idx) - 'a';
            if (children[childIdx] == null) {
                children[childIdx] = new Trie();
            }
            children[childIdx].insert(word, idx + 1);
        } else {
            isLeaf = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, 0, true);
    }

    private boolean search(String word, int idx, boolean shouldMatchAll) {
        if (idx < word.length()) {
            int childIdx = word.charAt(idx) - 'a';
            return children[childIdx] != null && children[childIdx].search(word, idx + 1, shouldMatchAll);
        } else {
            return !shouldMatchAll || isLeaf;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(prefix, 0, false);
    }
}
