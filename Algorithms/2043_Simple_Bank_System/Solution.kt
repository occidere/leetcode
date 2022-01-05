class Bank(private val balance: LongArray) {

    fun transfer(account1: Int, account2: Int, money: Long) =
        if (account1.isValidAccount() && account2.isValidAccount() && account1.hasMoreDepositThan(money)) {
            balance[account1 - 1] -= money
            balance[account2 - 1] += money
            true
        } else false

    fun deposit(account: Int, money: Long) =
        if (account.isValidAccount()) {
            balance[account - 1] += money
            true
        } else false

    fun withdraw(account: Int, money: Long) =
        if (account.isValidAccount() && account.hasMoreDepositThan(money)) {
            balance[account - 1] -= money
            true
        } else false

    private fun Int.isValidAccount() = this in 1..balance.size

    private fun Int.hasMoreDepositThan(money: Long) = money <= balance[this - 1]
}

/**
 * Your Bank object will be instantiated and called as such:
 * var obj = Bank(balance)
 * var param_1 = obj.transfer(account1,account2,money)
 * var param_2 = obj.deposit(account,money)
 * var param_3 = obj.withdraw(account,money)
 */
