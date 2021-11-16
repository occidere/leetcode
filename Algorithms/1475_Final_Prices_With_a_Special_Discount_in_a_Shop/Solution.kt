class Solution {
    fun finalPrices(prices: IntArray) = prices.indices.map { i ->
        (i + 1).until(prices.size)
            .find { j -> prices[j] <= prices[i] }?.let {
                prices[i] - prices[it]
            } ?: prices[i]
    }.toIntArray()
}
