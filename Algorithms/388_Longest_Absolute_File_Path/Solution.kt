import java.util.*

class Solution {
    fun lengthLongestPath(input: String) =
        Stack<Node>()
            .apply { push(Node("", -1)) }
            .run {
                input.split("\n")
                    .map { Node(depth = it.count { c -> c == '\t' }, name = it.replace("\t", "")) }
                    .map { node ->
                        while (peek().depth >= node.depth) {
                            pop()
                        }
                        push(node.apply { accLen += peek().accLen })
                        if (node.isFile) node.accLen + node.depth else 0
                    }.max()
            }

    private class Node(
        val name: String,
        val depth: Int,
        val isFile: Boolean = name.matches(Regex(".+\\..+$")),
        var accLen: Int = name.length
    )
}
