class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        for (c in letters) {
            if (c > target) {
                return c
            }
        }
        return letters[0]
    }
}
