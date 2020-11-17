import kotlin.math.max

class Solution {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        val inf = 0x3f3f3f3f
        val n = jobDifficulty.size
        val dp = Array(n) { IntArray(d + 1) { -1 } }
        /*  dp[i][j] = 마지막으로 일한 날짜의 끝 인덱스가 i이고, 남은 날이 j일 때의 최소 비용
        ex) dp[2][1] = 마지막으로 인덱스 2까지 일했고, 남은 날이 1일일 때의 최소 비용 */

        fun dfs(idxOfLastDay: Int, leftDay: Int): Int = when {
            leftDay == 0 && idxOfLastDay == n -> 0 // 모든 날짜에 작업 분배가 완료된 케이스
            leftDay == 0 || idxOfLastDay == n -> inf // 작업 분배가 잘못된 케이스: 더 남은 작업이 없는데 날짜가 남았거나, 작업이 남았는데 날짜가 안남은 경우
            dp[idxOfLastDay][leftDay] != -1 -> dp[idxOfLastDay][leftDay]
            else -> {
                var curDifficulty = jobDifficulty[idxOfLastDay]
                dp[idxOfLastDay][leftDay] = idxOfLastDay.until(n).map {
                    curDifficulty = max(curDifficulty, jobDifficulty[it])
                    dfs(it + 1, leftDay - 1) + curDifficulty
                }.minBy { it }!!
                dp[idxOfLastDay][leftDay]
            }
        }

        return dfs(0, d).let { if (it < inf) it else -1 } // 작업 분배를 정상적으로 할 수 없는 경우 inf 가 나오고 이를 -1로 바꿔 리턴함
    }
}