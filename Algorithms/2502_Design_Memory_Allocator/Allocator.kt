/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-15
 */
class Allocator(private val n: Int) {
    private val mem = IntArray(n) { -1 }
    private val allocates = mutableMapOf<Int, MutableList<Int>>()

    fun allocate(size: Int, mID: Int): Int {
        var acc = mem.take(size).sum()
        if (acc == -size) {
            return allocate(mID, 0 until size)
        }
        for (i in size until n) {
            acc = acc - mem[i - size] + mem[i]
            if (acc == -size) {
                return allocate(mID, i - size + 1..i)
            }
        }
        return -1
    }

    fun free(mID: Int): Int {
        var free = 0
        for (i in allocates[mID] ?: mutableListOf()) {
            mem[i] = -1
            ++free
        }
        allocates[mID]?.clear()
        return free
    }

    private fun allocate(mID: Int, range: IntRange): Int {
        if (!allocates.contains(mID)) {
            allocates[mID] = mutableListOf()
        }
        for (i in range) {
            mem[i] = mID
            allocates[mID]!!.add(i)
        }
        return range.first
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * var obj = Allocator(n)
 * var param_1 = obj.allocate(size,mID)
 * var param_2 = obj.free(mID)
 */
