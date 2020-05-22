package main

type Trie struct {
    isLeaf   bool
    children [26]*Trie
}

/* Initialize your data structure here. */
func Constructor() Trie {
    return Trie{}
}

func (trie *Trie) insert(word string, idx int) {
    if idx < len(word) {
        childIdx := int(word[idx] - 'a')
        if trie.children[childIdx] == nil {
            trie.children[childIdx] = &Trie{}
        }
        trie.children[childIdx].insert(word, idx+1)
    } else {
        trie.isLeaf = true
    }
}

/* Inserts a word into the trie. */
func (trie *Trie) Insert(word string) {
    trie.insert(word, 0)
}

func (trie *Trie) search(word string, idx int, shouldMatchAll bool) bool {
    if idx < len(word) {
        childIdx := int(word[idx] - 'a')
        return trie.children[childIdx] != nil && trie.children[childIdx].search(word, idx+1, shouldMatchAll)
    } else {
        return !shouldMatchAll || trie.isLeaf
    }
}

/* Returns if the word is in the trie. */
func (trie *Trie) Search(word string) bool {
    return trie.search(word, 0, true)
}

/* Returns if there is any word in the trie that starts with the given prefix. */
func (trie *Trie) StartsWith(prefix string) bool {
    return trie.search(prefix, 0, false)
}
