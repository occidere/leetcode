/*
 * 완전 동일한 root로 병합하는 방법이 아닌, 전부 root로 시작해서 하나씩 소거해나가는 방식
 */
object Solution {
  def findCircleNum(M: Array[Array[Int]]): Int = {
    val parent = Iterator.range(0, M.length).toArray // 전체 본인이 다 root 로 만들어놓고 시작

    def find(n: Int): Int = {
      if (parent(n) != n) parent(n) = find(parent(n))
      parent(n)
    }

    def union(elem: Int, root: Int): Unit = parent(find(elem)) = find(root)

    // 서로 연결된 경우, i의 최상위 root를 j의 최상위 root 하위에 편입
    M.indices.foreach(i => Range(i + 1, M.length)
      .foreach(j => if (M(i)(j) == 1) union(i, j)))

    // 본인이 root로 남아있는 애들이 병합 이후에도 살아남은 진짜 각 그룹별 root
    parent.zipWithIndex.count(xs => xs._1 == xs._2)
  }
}