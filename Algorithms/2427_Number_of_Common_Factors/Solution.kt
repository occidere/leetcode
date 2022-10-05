class Solution {
    fun commonFactors(a: Int, b: Int) =
        (1..kotlin.math.min(a, b)).count { a % it == 0 && b % it == 0 }
}
