import java.util.Stack

/**
 * Ref: https://me2.do/5u528itp
 * 
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-13
 */
class Solution {
    fun canSeePersonsCount(heights: IntArray): IntArray {
        val res = IntArray(heights.size) { 0 }
        val stk = Stack<Int>() // 오름차순으로 들어감
        for (i in heights.indices.reversed()) {
            // 나보다 작은 놈들 순서대로 확인 처리
            while (stk.isNotEmpty() && heights[i] > stk.peek()) {
                stk.pop()
                ++res[i]
            }
            // 나보다 큰놈 최종적으로 확인
            if (stk.isNotEmpty()) {
                ++res[i]
            }
            stk.push(heights[i]) // 내 자신 stack 에 추가
        }
        return res
    }
}
