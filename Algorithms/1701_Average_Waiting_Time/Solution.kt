class Solution {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var chefTime = 0
        var totalWaitingTime = .0
        for (c in customers) {
            if (chefTime < c[0]) {
                chefTime = c[0]
            }
            chefTime += c[1]
            totalWaitingTime += chefTime - c[0]
        }
        return totalWaitingTime / customers.size
    }
}
