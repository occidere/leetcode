class MyHashSet {

    private val hashSet = BooleanArray(1000001) { false }

    fun add(key: Int) {
        hashSet[key] = true
    }

    fun remove(key: Int) {
        hashSet[key] = false
    }

    fun contains(key: Int) = hashSet[key]
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
