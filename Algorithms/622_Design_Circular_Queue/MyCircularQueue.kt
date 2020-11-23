/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-11-23
 */

class MyCircularQueue(k: Int) {
    private val q = Array(k) { 0 }
    private var front = 0
    private var rear = 0
    private var size = 0

    fun enQueue(value: Int): Boolean = if (isFull()) false else {
        q[rear] = value
        rear = rear.incr()
        ++size
        true
    }

    fun deQueue(): Boolean = if (isEmpty()) false else {
        front = front.incr()
        --size
        true
    }

    fun Front(): Int = if (isEmpty()) -1 else q[front]

    fun Rear(): Int = if (isEmpty()) -1 else q[rear.decr()]

    fun isEmpty(): Boolean = size == 0

    fun isFull(): Boolean = size == q.size

    private fun Int.incr() = (this + 1) % q.size
    private fun Int.decr() = (this + q.size - 1) % q.size
}