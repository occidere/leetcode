class Solution {
    fun getHint(secret: String, guess: String): String {
        val (leftSecret, leftGuess) = mutableMapOf<Char, Int>().withDefault { 0 } to mutableListOf<Char>()
        val bulls = secret.indices.map {
            if (secret[it] == guess[it]) 1 else {
                leftSecret.merge(secret[it], 1, Integer::sum)
                leftGuess += guess[it]
                0
            }
        }.sum()
        val cows = leftGuess.map {
            if (leftSecret.getValue(it) > 0) {
                leftSecret[it] = leftSecret.getValue(it) - 1
                1
            } else 0
        }.sum()
        return "${bulls}A${cows}B"
    }
}
