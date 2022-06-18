/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-06-18
 */
class AllOne {

    private var head = Node(keys = mutableSetOf(""))
    private var tail = Node(keys = mutableSetOf(""))
    private val nodeMap = mutableMapOf<String, Node>()

    init {
        head.next = tail
        tail.prev = head
    }

    fun inc(key: String) {
        if (nodeMap.contains(key)) {
            nodeMap[key]!!.apply {
                getNextNode(freq + 1).addKey(key, nodeMap) // freq + 1 해서 신규 노드에 추가 (신규 노드 없을 시 생성)
                removeKey(key) // 기존 노드에서 key 삭제 & keys 가 empty 면 노드 삭제
            }
        } else {
            head.getNextNode(1).addKey(key, nodeMap) // freq = 1 인 노드가 없으면 생성, 있으면 그냥 key 추가
        }
    }

    fun dec(key: String) {
        nodeMap[key]!!.apply { // 무조건 있는 key 만 호출됨
            getPrevNode(freq - 1).addKey(key, nodeMap) // freq - 1 해서 신규 노드에 추가 (없을 시 생성)
            removeKey(key) // 기존 노드에서 key 삭제 & keys 가 empty 면 노드 삭제
        }
    }

    fun getMaxKey() = tail.prev!!.keys.first()

    fun getMinKey() = head.next!!.keys.first()

    private class Node(
        val freq: Int = 0,
        val keys: MutableSet<String> = mutableSetOf(),
        var prev: Node? = null,
        var next: Node? = null
    ) {
        fun getNextNode(freq: Int) =
            if (next!!.freq == freq) next!! else Node(freq, prev = this, next = next).also {
                next!!.prev = it
                next = it
            }

        fun getPrevNode(freq: Int) =
            if (prev!!.freq == freq) prev!! else Node(freq, prev = prev, next = this).also {
                prev!!.next = it
                prev = it
            }

        fun addKey(key: String, nodeMap: MutableMap<String, Node>) {
            keys += key
            nodeMap[key] = this
        }

        fun removeKey(key: String) {
            keys -= key
            if (keys.isEmpty()) {
                prev!!.next = next
                next!!.prev = prev
            }
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * var obj = AllOne()
 * obj.inc(key)
 * obj.dec(key)
 * var param_3 = obj.getMaxKey()
 * var param_4 = obj.getMinKey()
 */
