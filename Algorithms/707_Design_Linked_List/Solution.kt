/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-04-12
 */
class MyLinkedList() {

    private val head = ListNode(-1)
    private val tail = ListNode(-1)
    private var size = 0

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(index: Int) = if (index.isValidIndex()) getListNodeAt(index).`val` else -1

    fun addAtHead(`val`: Int) {
        val old = head.next!!
        val new = ListNode(`val`, head, old)
        head.next = new
        old.prev = new
        ++size
    }

    fun addAtTail(`val`: Int) {
        val old = tail.prev!!
        val new = ListNode(`val`, old, tail)
        tail.prev = new
        old.next = new
        ++size
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index == size) {
            addAtTail(`val`)
        } else if (index.isValidIndex()) {
            val old = getListNodeAt(index)
            val new = ListNode(`val`, old.prev, old)
            old.prev!!.next = new
            old.prev = new
            ++size
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index.isValidIndex()) {
            val old = getListNodeAt(index)
            val (oldPrev, oldNext) = old.prev!! to old.next!!
            oldPrev.next = old.next
            oldNext.prev = old.prev
            --size
        }
    }

    private fun Int.isValidIndex() = this in 0 until size

    private fun getListNodeAt(idx: Int): ListNode {
        val half = size.shr(1) // 5 -> 2, 4 -> 2, 3 -> 1
        var node: ListNode
        if (idx < half) {
            node = head
            repeat(idx + 1) {
                node = node.next!!
            }
        } else {
            node = tail
            repeat(size - idx) {
                node = node.prev!!
            }
        }
        return node
    }

    private data class ListNode(val `val`: Int, var prev: ListNode? = null, var next: ListNode? = null)

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
