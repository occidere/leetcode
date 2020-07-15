object Solution {
  def anagramMappings(A: Array[Int], B: Array[Int]): Array[Int] = {
    val anagramMap = B.zipWithIndex.toMap
    A.map(anagramMap(_))
  }
}