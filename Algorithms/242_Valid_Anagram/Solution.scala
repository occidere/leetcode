object Solution {
  def isAnagram(s: String, t: String): Boolean = s.map(_ -> 1).groupMapReduce(_._1)(_._2)(_ + _) ==
    t.map(_ -> 1).groupMapReduce(_._1)(_._2)(_ + _)

  def main(args: Array[String]): Unit = {
    println(isAnagram("anagram", "nagaram"))
  }
}