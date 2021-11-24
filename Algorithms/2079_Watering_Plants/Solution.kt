class Solution {
    fun wateringPlants(plants: IntArray, capacity: Int) = ArrayDeque<Int>().run {
        addAll(plants.toList())
        var (curCap, steps, dist) = Triple(capacity - removeFirst(), 1, 1)
        while (isNotEmpty()) {
            removeFirst().also {
                if (curCap < it) {
                    steps += dist.shl(1)
                    addFirst(it)
                    curCap = capacity
                } else {
                    curCap -= it
                    ++steps
                    ++dist
                }
            }
        }
        steps
    }
}
