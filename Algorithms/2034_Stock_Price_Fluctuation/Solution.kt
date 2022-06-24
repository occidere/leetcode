import java.util.PriorityQueue

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-06-24
 */
class StockPrice {

    private val minHeap = PriorityQueue<Stock>()
    private val maxHeap = PriorityQueue<Stock>(Comparator { x, y -> y.price - x.price })
    private val timeline = sortedMapOf<Int, Stock>()
    private val deleted = mutableSetOf<Stock>()

    fun update(timestamp: Int, price: Int) {
        val stock = Stock(price)
        if (timeline.contains(timestamp)) {
            deleted += timeline[timestamp]!!
        }
        timeline[timestamp] = stock
        minHeap.offer(stock)
        maxHeap.offer(stock)
    }

    fun current() = timeline[timeline.lastKey()!!]!!.price

    fun maximum(): Int {
        while (deleted.contains(maxHeap.peek())) {
            maxHeap.poll()
        }
        return maxHeap.peek().price
    }

    fun minimum(): Int {
        while (deleted.contains(minHeap.peek())) {
            minHeap.poll()
        }
        return minHeap.peek().price
    }

    private class Stock(val price: Int) : Comparable<Stock> {
        override fun compareTo(other: Stock) = price - other.price
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * var obj = StockPrice()
 * obj.update(timestamp,price)
 * var param_2 = obj.current()
 * var param_3 = obj.maximum()
 * var param_4 = obj.minimum()
 */
