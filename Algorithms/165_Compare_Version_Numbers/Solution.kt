class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val (v1, v2) = version1.split(".").toMutableList() to version2.split(".").toMutableList()
        if (v1.size < v2.size) {
            v1.addAll(List(v2.size - v1.size) { "0" })
        } else if (v1.size > v2.size) {
            v2.addAll(List(v1.size - v2.size) { "0" })
        }

        for (p in v1.map { it.toInt() }.zip(v2.map { it.toInt() })) {
            if (p.first < p.second) {
                return -1
            } else if (p.first > p.second) {
                return 1
            }
        }
        return 0
    }
}
