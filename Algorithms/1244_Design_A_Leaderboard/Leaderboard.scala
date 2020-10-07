/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-10-07
 */
class Leaderboard() {
  private val board = scala.collection.mutable.Map[Int, Int]()
  def addScore(playerId: Int, score: Int): Unit = board(playerId) = if (board.contains(playerId)) board(playerId) + score else score
  def top(K: Int): Int = board.values.toList.sortBy(-_).take(K).sum
  def reset(playerId: Int): Unit = board(playerId) = 0
}

object Leaderboard extends App {
  val lb = new Leaderboard()
  lb.addScore(1, 73)
  lb.addScore(2, 26)
  lb.addScore(3, 39)
  lb.addScore(4, 51)
  lb.addScore(5, 4)

  println(lb.top(1))

  lb.reset(1)
  lb.reset(2)

  lb.addScore(2, 51)

  println(lb.top(3))
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * var obj = new Leaderboard()
 * obj.addScore(playerId,score)
 * var param_2 = obj.top(K)
 * obj.reset(playerId)
 */
