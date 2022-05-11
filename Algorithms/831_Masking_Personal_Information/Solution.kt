class Solution {
    fun maskPII(s: String) = if (s.isEmail()) s.maskingEmail() else s.maskingPhoneNumber()

    private fun String.isEmail() = contains('@')

    private fun String.maskingEmail() = toLowerCase().let {
        val (name, domain) = it.split('@')
        "${name.first()}*****${name.last()}@$domain"
    }

    private fun String.maskingPhoneNumber(): String {
        val nums = replace(Regex("\\(*\\)*\\+*-* *"), "").trim()
        val ccLen = if (nums.length > 10) nums.length - 10 else 0
        return "${if (ccLen != 0) "+" + ((1..ccLen).joinToString("") { "*" }) + "-" else ""}***-***-${nums.takeLast(4)}"
    }
}
