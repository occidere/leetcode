class CustomStack(private val maxSize: Int) {
    private var size = 0
    private val stk = IntArray(maxSize)

    fun push(x: Int) {
        if (size < maxSize) {
            stk[size++] = x
        }
    }

    fun pop(): Int = if (size > 0) stk[--size] else -1

    fun increment(k: Int, `val`: Int) = 0.until(Integer.min(size, k)).forEach { stk[it] += `val` }
}