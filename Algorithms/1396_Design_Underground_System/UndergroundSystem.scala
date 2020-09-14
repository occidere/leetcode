import scala.collection.mutable

object UndergroundSystem {
  private val ins = mutable.Map[Int, (String, Int)]()
  private val trips = mutable.Map[String, (Int, Int)]()
}

class UndergroundSystem() {

  import UndergroundSystem._

  def checkIn(id: Int, stationName: String, t: Int): Unit = ins(id) = (stationName, t)

  def checkOut(id: Int, stationName: String, t: Int): Unit = {
    val in = ins(id)
    val key = in._1 + "_" + stationName
    if (!trips.contains(key)) trips(key) = (0, 0)
    trips(key) = (trips(key)._1 + t - in._2, trips(key)._2 + 1)
    ins.remove(id)
  }

  def getAverageTime(startStation: String, endStation: String): Double = {
    val trip = trips(startStation + "_" + endStation)
    trip._1.toDouble / trip._2
  }
}