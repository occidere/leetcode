/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-11-23
 */
class MyCircularQueue(_k: Int) {
  private val q = Array.fill(_k) { 0 }
  private var front = 0
  private var rear = 0
  private var size = 0

  def enQueue(value: Int): Boolean = if (isFull()) false else {
    q(rear) = value
    rear = incr(rear)
    size += 1
    true
  }

  def deQueue(): Boolean = if (isEmpty()) false else {
    front = incr(front)
    size -= 1
    true
  }


  def Front(): Int = if (isEmpty()) -1 else q(front)

  def Rear(): Int = if (isEmpty()) -1 else q(decr(rear))

  def isEmpty(): Boolean = size == 0

  def isFull(): Boolean = size == q.length

  private def incr(num: Int): Int = (num + 1) % q.length

  private def decr(num: Int): Int = (num + q.length - 1) % q.length
}

