object Solution {
  def closeStrings(word1: String, word2: String): Boolean = word1.toSet == word2.toSet &&
    word1.groupMapReduce(x => x)(_ => 1)(_ + _).values.toSet == word2.groupMapReduce(x => x)(_ => 1)(_ + _).values.toSet
}

