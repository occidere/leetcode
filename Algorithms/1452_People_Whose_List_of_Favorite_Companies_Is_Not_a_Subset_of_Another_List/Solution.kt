class Solution {
    fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
        val sorted = favoriteCompanies
            .map { it.toSet() }
            .zip(favoriteCompanies.indices)
            .sortedBy { it.first.size }
            .toTypedArray()
        val subsets = mutableListOf<Int>()
        for (i in sorted.indices) {
            var isSubset = false
            for (j in i + 1 until sorted.size) {
                if (sorted[j].first.containsAll(sorted[i].first)) {
                    isSubset = true
                    break
                }
            }
            if (!isSubset) {
                subsets += sorted[i].second
            }
        }
        return subsets.sorted()
    }
}
