class Solution {
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val (map1, map2) = list1.zip(list1.indices).toMap() to list2.zip(list2.indices).toMap()
        return list1.toSet()
            .intersect(list2.toSet())
            .map { it to (map1[it]!! + map2[it]!!) }
            .let { xs ->
                val min = xs.map { it.second }.min()
                xs.filter { it.second == min }
                    .map { it.first }
                    .toTypedArray()
            }

    }
}
