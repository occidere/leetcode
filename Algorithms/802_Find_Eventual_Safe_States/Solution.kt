/**
 * Ref: https://me2.do/5g3ur27M
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-26
 */
class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>) = Array(graph.size) { State.NOT_VISIT }
        .let { states -> graph.indices.filter { graph.dfs(it, states) } }

    /*
    If cur node is not visited node, set as unsafe first and change it to safe after trace all others safely.
    If cur node is already visited node, it should be safe node.
     */
    private fun Array<IntArray>.dfs(cur: Int, states: Array<State>): Boolean {
        if (states[cur] == State.NOT_VISIT) {
            states[cur] = State.UNSAFE
            for (next in this[cur]) {
                if (!dfs(next, states)) {
                    return false
                }
            }
            states[cur] = State.SAFE
        }
        return states[cur] == State.SAFE
    }

    private enum class State {
        NOT_VISIT,
        SAFE,
        UNSAFE
    }
}
