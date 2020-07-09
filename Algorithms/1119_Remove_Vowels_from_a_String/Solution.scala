object Solution {
  def removeVowels(S: String): String = (for (s <- S) yield s match {
    case 'a' | 'e' | 'i' | 'o' | 'u' => ""
    case _ => s
  }).foldLeft("")(_ + _)
}