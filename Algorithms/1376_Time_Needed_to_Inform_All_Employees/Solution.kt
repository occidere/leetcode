class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray) = informTime.indices
        .zip(informTime.toList())
        .filter { it.second == 0 }
        .map {
            var (idx, totalCost) = it
            while (true) {
                idx = manager[idx]
                if (idx == -1) {
                    break
                }
                totalCost += informTime[idx]
            }
            totalCost
        }.max()!!
}
