object Solution {
  def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int): Int = {
    var (units, loaded) = 0 -> 0
    val sorted = boxTypes.sortWith((x, y) => x(1) > y(1))
    for (box <- sorted) {
      if (loaded + box(0) >= truckSize) {
        units += (truckSize - loaded) * box(1)
        return units
      }
      loaded += box(0)
      units += box(0) * box(1)
    }
    boxTypes.map(xs => xs(0) * xs(1)).sum
  }
}