class CustomStack(_maxSize: Int) {

  private var size = 0
  private val stk = Array.fill(_maxSize)(0)

  def push(x: Int): Unit = if (size < _maxSize) {
    stk(size) = x
    size += 1
  }

  def pop(): Int = if (size == 0) -1 else {
    size -= 1
    stk(size)
  }

  def increment(k: Int, `val`: Int): Unit = Range(0, math.min(k, size)).foreach(stk(_) += `val`)

}