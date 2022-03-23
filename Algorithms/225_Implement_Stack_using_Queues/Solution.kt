class MyStack {

    private val queue = mutableListOf<Int>()

    fun push(x: Int) {
        queue += x
        repeat(queue.size - 1) {
            queue.add(queue.removeAt(0))
        }
    }

    fun pop() = queue.removeAt(0)

    fun top() = queue.first()

    fun empty() = queue.isEmpty()
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
