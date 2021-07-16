class Solution {
    fun displayTable(orders: List<List<String>>): List<List<String>> {
        val grp = mutableMapOf<Int, MutableMap<String, Int>>()
        for (order in orders) {
            val table = order[1].toInt()
            grp.putIfAbsent(table, mutableMapOf())
            grp[table]!!.merge(order.last(), 1, Integer::sum)
        }
        val tables = orders.map { it[1].toInt() }.toSortedSet()
        val foods = orders.map { it.last() }.toSortedSet()

        return listOf(listOf("Table") + foods) + tables.map { table ->
            listOf("$table") + foods.map { food ->
                "${grp.getOrDefault(table, mutableMapOf()).getOrDefault(food, 0)}"
            }.toList()
        }.toList()
    }
}
