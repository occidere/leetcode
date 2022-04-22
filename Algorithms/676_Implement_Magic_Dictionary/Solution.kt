class MagicDictionary {

    private val dicts = mutableSetOf<String>()

    fun buildDict(dictionary: Array<String>) {
        dicts.addAll(dictionary)
    }

    fun search(searchWord: String) = dicts.filter { it.length == searchWord.length }
        .any { w -> w.indices.count { w[it] != searchWord[it] } == 1 }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = MagicDictionary()
 * obj.buildDict(dictionary)
 * var param_2 = obj.search(searchWord)
 */
