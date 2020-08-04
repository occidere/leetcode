object Solution {
  def findDuplicate(paths: Array[String]): List[List[String]] = paths.map(_.split(" "))
    .flatMap(xs => xs.tail
      .flatMap(_.split(" "))
      .map(_.replace(")", "").split("\\("))
      .map(x => (x(1), s"${xs(0)}/${x(0)}"))
    ).groupMap(_._1)(_._2)
    .filter(_._2.length > 1)
    .map(_._2.toList)
    .toList
}