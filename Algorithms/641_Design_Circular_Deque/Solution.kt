/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-06-10
 */
class MyCircularDeque(private val k: Int) {

    private var size = 0
    private val head = Node(-1)

    fun insertFront(value: Int) = if (isFull()) false else {
        val newNode = Node(value)
        head.right.left = newNode
        newNode.right = head.right
        head.right = newNode
        newNode.left = head
        ++size
        true
    }

    fun insertLast(value: Int) = if (isFull()) false else {
        val newNode = Node(value)
        head.left.right = newNode
        newNode.left = head.left
        head.left = newNode
        newNode.right = head
        ++size
        true
    }

    fun deleteFront() = if (isEmpty()) false else {
        head.right.right.left = head
        head.right = head.right.right
        --size
        true
    }

    fun deleteLast() = if (isEmpty()) false else {
        head.left.left.right = head
        head.left = head.left.left
        --size
        true
    }

    fun getFront() = if (size == 0) -1 else head.right.nodeVal

    fun getRear() = if (size == 0) -1 else head.left.nodeVal

    fun isEmpty() = size == 0

    fun isFull() = size == k

    private data class Node(val nodeVal: Int) {
        var left: Node = this
        var right: Node = this
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
