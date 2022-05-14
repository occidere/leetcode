import java.util.*

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val board = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((from, to, cost) in times) {
            board[from - 1].add(Pair(to - 1, cost))
        }

        // dijkstra
        val dist = IntArray(n) { 0x3f3f3f3f }
        dist[k - 1] = 0
        val pq = PriorityQueue<Pair<Int, Int>>(Comparator { x, y -> x.second - y.second })
        pq.offer(k - 1 to dist[k - 1])

        while (pq.isNotEmpty()) {
            val (curNode, curCost) = pq.poll()
            for ((nextNode, nextCost) in board[curNode]) {
                if (curCost + nextCost < dist[nextNode]) {
                    dist[nextNode] = curCost + nextCost
                    pq.offer(nextNode to dist[nextNode])
                }
            }
        }
        
        return dist.max()!!.let { if (it == 0x3f3f3f3f) -1 else it }
    }
}
