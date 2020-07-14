object Solution {
  def calculateTime(keyboard: String, word: String): Int = word.foldLeft((keyboard(0), 0))((t, c) => (c, t._2 + (keyboard.indexOf(t._1) - keyboard.indexOf(c)).abs))._2
}