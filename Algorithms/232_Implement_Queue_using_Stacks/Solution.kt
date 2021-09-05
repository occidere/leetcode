import java.util.*

class MyQueue() {

    /** Initialize your data structure here. */
    private val pushStk = Stack<Int>()
    private val popStk = Stack<Int>()


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        pushStk.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop() = popStk.let {
        if (it.isEmpty()) {
            pushStk.popAllInto(it)
        }
        it.pop()
    }

    /** Get the front element. */
    fun peek() = popStk.let {
        if (it.isEmpty()) {
            pushStk.popAllInto(it)
        }
        it.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty() = pushStk.isEmpty() && popStk.isEmpty()

    private fun Stack<Int>.popAllInto(stk: Stack<Int>) {
        while (this.isNotEmpty()) {
            stk.push(this.pop())
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
