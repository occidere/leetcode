class FrontMiddleBackQueue {
    private var size = 0

    private val frontHead = Node(-1)
    private val middleHead = Node(-1)
    private val rearHead = Node(-1)

    fun pushFront(`val`: Int) {
        val node = Node(`val`)
        if (size == 0) initPush(node) else {
            frontHead.next!!.prev = node
            node.next = frontHead.next

            frontHead.next = node
            node.prev = frontHead

            moveMiddleForwardBasedOnSize()
        }
        ++size
    }

    fun pushMiddle(`val`: Int) {
        val node = Node(`val`)
        if (size == 0) initPush(node) else {
            if (size % 2 == 1) {
                middleHead.prev!!.prev!!.next = node
                node.prev = middleHead.prev!!.prev

                middleHead.next!!.prev = node
                node.next = middleHead.next

                middleHead.prev = node
            } else {
                middleHead.prev!!.next = node
                node.prev = middleHead.prev

                middleHead.next!!.prev = node
                node.next = middleHead.next

                middleHead.prev = node
                middleHead.next = node
            }
        }
        ++size
    }

    fun pushBack(`val`: Int) {
        val node = Node(`val`)
        if (size == 0) initPush(node) else {
            rearHead.prev!!.next = node
            node.prev = rearHead.prev

            rearHead.prev = node
            node.next = rearHead

            moveMiddleBackwardBasedOnSize()
        }
        ++size
    }

    fun popFront(): Int {
        return if (size == 0) -1 else frontHead.next!!.value.apply {
            frontHead.next!!.next!!.prev = frontHead
            frontHead.next = frontHead.next!!.next

            moveMiddleBackwardBasedOnSize()
            --size
        }
    }

    fun popMiddle(): Int {
        if (size == 0) {
            return -1
        }

        val ret = middleHead.prev!!
        if (size % 2 == 1) {
            middleHead.prev = middleHead.prev!!.prev
            middleHead.next = middleHead.next!!.next

            middleHead.prev!!.next = middleHead.next
            middleHead.next!!.prev = middleHead.prev
        } else {
            middleHead.next!!.prev = middleHead.prev!!.prev
            middleHead.prev!!.prev!!.next = middleHead.next

            middleHead.prev = middleHead.prev!!.next
        }
        --size
        return ret.value
    }

    fun popBack(): Int {
        return if (size == 0) -1 else rearHead.prev!!.value.apply {
            rearHead.prev!!.prev!!.next = rearHead
            rearHead.prev = rearHead.prev!!.prev

            moveMiddleForwardBasedOnSize()
            --size
        }
    }

    private fun initPush(node: Node) {
        frontHead.next = node
        node.prev = frontHead

        middleHead.prev = node
        middleHead.next = node

        rearHead.prev = node
        node.next = rearHead
    }

    private fun moveMiddleForwardBasedOnSize() {
        if (size % 2 == 1) {
            middleHead.prev = middleHead.prev!!.prev
        } else {
            middleHead.next = middleHead.next!!.prev
        }
    }

    private fun moveMiddleBackwardBasedOnSize() {
        if (size % 2 == 1) {
            middleHead.next = middleHead.next!!.next
        } else {
            middleHead.prev = middleHead.prev!!.next
        }
    }

    fun printNodes() {
        var head: Node? = frontHead
        val nodes = mutableListOf<String>()
        while (head != null) {
            if (head.value != -1) {
                var str = "${head.value}"
                if (head == middleHead.prev) {
                    str = "($str"
                }
                if (head == middleHead.next) {
                    str = "$str)"
                }
                if (head == frontHead.next) {
                    str = "<$str"
                }
                if (head == rearHead.prev) {
                    str = "$str>"
                }
                nodes += str
            }
            head = head.next
        }
        println("$nodes (size: $size)")
    }

    private class Node(
        val value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * var obj = FrontMiddleBackQueue()
 * obj.pushFront(`val`)
 * obj.pushMiddle(`val`)
 * obj.pushBack(`val`)
 * var param_4 = obj.popFront()
 * var param_5 = obj.popMiddle()
 * var param_6 = obj.popBack()
 */

fun main() {
    val q = FrontMiddleBackQueue()
    q.pushFront(5)
    q.printNodes()

    q.pushFront(4)
    q.printNodes()

    q.pushFront(1)
    q.printNodes()

    q.pushMiddle(2)
    q.printNodes()

    q.pushMiddle(3)
    q.printNodes()

    q.pushBack(6)
    q.printNodes()

    q.pushBack(7)
    q.printNodes()

    println("popFront=${q.popFront()}")
    q.printNodes()

    println("popBack=${q.popBack()}")
    q.printNodes()

    println("popMid=${q.popMiddle()}")
    q.printNodes()

    println("popMid=${q.popMiddle()}")
    q.printNodes()

    println("popMid=${q.popMiddle()}")
    q.printNodes()

    println("popMid=${q.popMiddle()}")
    q.printNodes()

    println("popMid=${q.popMiddle()}")
    q.printNodes()
}
