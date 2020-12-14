class Solution {
    // 참고: https://leetcode.com/problems/remove-comments/discuss/109195/1-liners/111260
    fun removeComments(source: Array<String>): List<String> = source.joinToString("\n")
            .replace(Regex("//.*|/\\*(.|\n)*?\\*/"), "")
            .split("\n")
            .filter { it.isNotEmpty() }
            .toList()
}

fun main() {
    println(Solution().removeComments(arrayOf(
            "/*Test program */",
            "int main()",
            "{ ",
            "  // variable declaration ",
            "int a, b, c;",
            "/* This is a test",
            "   multiline  ",
            "   comment for ",
            "   testing */",
            "a = b + c;",
            "}"
    )))


    println(Solution().removeComments(arrayOf("a/*comment", "line", "more_comment*/b")))

    // ["struct Node{","    ","    int size;","    int val;","};"]
    println(Solution().removeComments(arrayOf(
            "struct Node{",
            "    /*/ declare members;/**/",
            "    int size;",
            "    /**/int val;",
            "};"
    )))

    // ["void func(int k) {","   k = k*2/4;","   k = k/2;*/","}"]
    println(Solution().removeComments(arrayOf(
            "void func(int k) {",
            "// this function does nothing /*",
            "   k = k*2/4;",
            "   k = k/2;*/", "}"
    )))
    // ["main() {","   double s = 33;","   cout << s;","}"]
    println(Solution().removeComments(arrayOf(
            "main() {",
            "/* here is commments",
            "  // still comments */",
            "   double s = 33;",
            "   cout << s;", "}"
    )))

    // ["af"]
    println(Solution().removeComments(arrayOf("a/*/b//*c", "blank", "d//*e/*/f")))
}