class Solution {
    fun alphabetBoardPath(target: String) = "a$target".map { (it - 'a') / 5 to (it - 'a') % 5 }
        .zipWithNext()
        .joinToString("") { (cur, next) ->
            'L'.generate(cur.second - next.second) +
                    'U'.generate(cur.first - next.first) +
                    'D'.generate(next.first - cur.first) +
                    'R'.generate(next.second - cur.second) +
                    "!"
        }

    private fun Char.generate(times: Int) = 0.until(times)
        .map { this }
        .joinToString("")
}
