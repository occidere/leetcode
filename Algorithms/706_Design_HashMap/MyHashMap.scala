class MyHashMap() {
  /** Initialize your data structure here. */
  private val arr = Array.fill(1000001)(-1)

  /** value will always be non-negative. */
  def put(key: Int, value: Int): Unit = arr(key) = value

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  def get(key: Int): Int = arr(key)

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  def remove(key: Int): Unit = arr(key) = -1
}