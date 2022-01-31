class Solution {
    /*
    A -> B -> C -> D -> E 의 경로가 있을 때,
    A 에서 시작해서 가다가 D -> E 에서 연료 부족으로 멈췄다면, 다음 시도는 B 가 아닌 D 로 점프 가능.
    이유는, A ~> D 까지는 어디서 출발하던 연료갸 + 인데, A 이후부터 출발해봤자 + 가 되긴 하지만 결코 D -> E 로 갈 연료가 남진 않기 때문 (오히려 A 에서 출발하는 것 보다 부족)
    따라서 연료 부족으로 멈춘 지점인 D 부터 다시 시작해서 시간 단축 가능.
    또한 '전체 연료량' 과, 출발 지점부터 계산한 '현재 연료량' 을 분리해서 공간복잡도도 단축 가능

    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var (totalLeftFuel, curLeftFuel, startIdx) = Triple(0, 0, 0)
        for (i in gas.indices) {
            totalLeftFuel += gas[i] - cost[i]
            curLeftFuel += gas[i] - cost[i]
            if (curLeftFuel < 0) {
                startIdx = i + 1
                curLeftFuel = 0
            }
        }
        return if (totalLeftFuel < 0) -1 else startIdx
    }

    /*
    2020-11-16 엔 AC 받았지만 2022-01-31 엔 TLE 발생
    
    Time Complexity: O(N^2)
    Space Complexity: O(N)
     */
//    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int = gas.zip(cost)
//        .map { it.first - it.second }
//        .toIntArray()
//        .let { gas.indices.find { i -> it.isPossible(i) } ?: -1 }
//
//    private fun IntArray.isPossible(start: Int): Boolean {
//        var gas = 0
//        return start.until(start + this.size)
//            .map { gas += this[it % this.size]; gas >= 0 }
//            .reduce { acc, b -> acc && b }
//    }
}
