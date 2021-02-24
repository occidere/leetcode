object Solution {
  def countConsistentStrings(allowed: String, words: Array[String]): Int = words.map(_.toSet.diff(allowed.toSet)).count(_.isEmpty)
}
