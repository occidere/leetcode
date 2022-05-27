class Cashier(
    private val n: Int,
    discount: Int,
    products: IntArray,
    prices: IntArray
) {

    private var orderCount = 0
    private val df = (100 - discount).toDouble() / 100.0
    private val priceByProd = products.zip(prices).toMap()

    fun getBill(product: IntArray, amount: IntArray) = product.zip(amount)
        .map { priceByProd[it.first]!! * it.second }
        .sum()
        .toDouble() * (if (++orderCount % n == 0) df else 1.0)
}

/**
 * Your Cashier object will be instantiated and called as such:
 * var obj = Cashier(n, discount, products, prices)
 * var param_1 = obj.getBill(product,amount)
 */
