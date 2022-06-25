class OrderedStream(private val n: Int) {
    private val arr = Array(n) { "" }
    private var ptr = 0

    fun insert(idKey: Int, value: String): List<String> {
        arr[idKey - 1] = value
        val ret = mutableListOf<String>()
        while (ptr < n && arr[ptr].isNotBlank()) {
            ret += arr[ptr++]
        }
        return ret
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = OrderedStream(n)
 * var param_1 = obj.insert(idKey,value)
 */
