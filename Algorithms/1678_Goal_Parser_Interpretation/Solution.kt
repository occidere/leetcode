class Solution {
    fun interpret(command: String): String =
            command.replace("()", "o").replace("(al)", "al")
}