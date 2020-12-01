class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int = accounts.map { it.sum() }.max()!!
}