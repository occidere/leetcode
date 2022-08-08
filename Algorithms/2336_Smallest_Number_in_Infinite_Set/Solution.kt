import java.util.*

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-08
 */
class SmallestInfiniteSet() {

    private val pq = PriorityQueue<Int>().apply { addAll(1..1000) }
    private val set = (1..1000).toMutableSet()

    fun popSmallest() = pq.poll().also { set.remove(it) }

    fun addBack(num: Int) {
        if (!set.contains(num)) {
            pq.add(num)
            set.add(num)
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */
