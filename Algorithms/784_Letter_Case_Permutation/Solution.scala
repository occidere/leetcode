object Solution {
  def letterCasePermutation(S: String, idx: Int = 0): List[String] = if (idx == S.length) List(S) else
    (letterCasePermutation(
      s"${S.substring(0, idx)}${S.charAt(idx).toLower}${S.substring(idx + 1)}", idx + 1) ++
      letterCasePermutation(
        s"${S.substring(0, idx)}${S.charAt(idx).toUpper}${S.substring(idx + 1)}", idx + 1)
      ).distinct

  def main(args: Array[String]): Unit = {
    println(letterCasePermutation("a"))
  }
}