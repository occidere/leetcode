import scala.collection.mutable

object Solution {
  def killProcess(pid: List[Int], ppid: List[Int], kill: Int): List[Int] = {
    val group = ppid.zip(pid)
      .map(x => x._1 -> mutable.ListBuffer(x._2))
      .groupMapReduce(_._1)(_._2)(_ ++= _)
    val killed = mutable.ListBuffer[Int]()
    val q = mutable.Queue[Int](kill)
    while (q.nonEmpty) {
      val parent = q.dequeue()
      killed += parent
      q ++= group.getOrElse(parent, List())
    }
    killed.toList
  }
}