package main

type WordDictionary struct {
    isLeaf   bool
    children [26]*WordDictionary
}

/** Initialize your data structure here. */
func Constructor() WordDictionary {
    return WordDictionary{}
}

/** Adds a word into the data structure. */
func (wd *WordDictionary) AddWord(word string) {
    wd.addWord(word, 0)
}

func (wd *WordDictionary) addWord(word string, idx int) {
    if idx < len(word) {
        childIdx := int(word[idx]) - 'a'
        if wd.children[childIdx] == nil {
            wd.children[childIdx] = &WordDictionary{}
        }
        wd.children[childIdx].addWord(word, idx+1)
    } else {
        wd.isLeaf = true
    }
}

/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
func (wd *WordDictionary) Search(word string) bool {
    return wd.search(word, 0)
}

func (wd *WordDictionary) search(word string, idx int) bool {
    if idx >= len(word) {
        return wd.isLeaf
    }

    childIdx := int(word[idx]) - 'a'
    if childIdx >= 0 {
        return wd.children[childIdx] != nil && wd.children[childIdx].search(word, idx+1)
    }

    for _, next := range wd.children { // '.' case
        if next != nil && next.search(word, idx+1) {
            return true
        }
    }
    return false
}