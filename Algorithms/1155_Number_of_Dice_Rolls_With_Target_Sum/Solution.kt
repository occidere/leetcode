/**
 * Ref: https://me2.do/5pErmdKl
 * 
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-02
 */
class Solution {
    fun numRollsToTarget(numberOfDices: Int, faceOfDice: Int, target: Int): Int {
        val dp = Array(numberOfDices + 1) { LongArray(target + 1) { 0 } }
        dp[0][0] = 1

        for (usedDices in 1..numberOfDices) {
            for (faceSum in 0..target) {
                for (curFace in 1..faceOfDice) {
                    if (faceSum >= curFace) {
                        // dp[지금까지 사용한 주사위 수][만들고 싶은 주사위 눈들의 합] += dp[직전에 사용한 주사위 수][만들고 싶은 눈들의 합 - 현재 주사위 눈금]
                        dp[usedDices][faceSum] = (dp[usedDices][faceSum] + dp[usedDices - 1][faceSum - curFace]) % 1000000007
//                        println("usedDices: $usedDices, faceSum: $faceSum, curFace: $curFace, dp[$usedDices][$faceSum] = ${dp[usedDices][faceSum]}")
                    } else {
                        break
                    }
                }
            }
        }

        return dp[numberOfDices][target].toInt()
    }
}
