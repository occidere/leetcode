class Solution {
    fun invalidTransactions(transactions: Array<String>) = transactions.map { it.split(",") }
        .map { Transaction(it[0], it[1].toInt(), it[2].toInt(), it[3]) }
        .sortedBy { it.time }
        .toTypedArray()
        .also {
            for (i in 0 until it.size - 1) {
                for (j in i + 1 until it.size) {
                    if (it[j].time - it[i].time > 60) {
                        break
                    } else if (it[i].name == it[j].name && it[i].city != it[j].city) {
                        it[i].valid = false
                        it[j].valid = false
                    }
                }
            }
        }.filterNot { it.valid }
        .map { "${it.name},${it.time},${it.amount},${it.city}" }


    data class Transaction(
        val name: String,
        val time: Int,
        val amount: Int,
        val city: String,
        var valid: Boolean = amount <= 1000
    )
}
