class Solution {
    fun partition(s: String): List<List<String>> {
        val palindromes = mutableSetOf<String>()
        val ans = mutableListOf<List<String>>()

        fun dfs(idx: Int, palindrome: MutableList<String>) {
            if (idx == s.length) {
                ans += palindrome.toList()
                return
            }

            for (i in idx until s.length) {
                val left = s.substring(idx, i + 1)
                if (palindromes.contains(left) || left.isPalindrome()) {
                    palindromes += left
                    palindrome += left
                    dfs(i + 1, palindrome)
                    palindrome.removeAt(palindrome.size - 1)
                }
            }
        }

        dfs(0, mutableListOf())

        return ans.filterNot { it.any { it.isEmpty() } }
            .filter { it.joinToString("") == s }
    }

    private fun String.isPalindrome(): Boolean {
        for (i in 0..length.shr(1)) {
            if (this[i] != this[length - i - 1]) {
                return false
            }
        }
        return true
    }
}
