class Solution {
    fun expressiveWords(s: String, words: Array<String>) = s.toFreqPairs()
        .run { words.count { it.toFreqPairs().isExtensibleTo(this) } }

    private fun String.toFreqPairs(): List<Pair<Char, Int>> {
        val freqPairs = mutableListOf<Pair<Char, Int>>()
        var (ch, freq) = first() to 1
        for (c in drop(1)) {
            if (ch == c) {
                ++freq
            } else {
                freqPairs += ch to freq
                ch = c
                freq = 1
            }
        }
        freqPairs += ch to freq
        return freqPairs
    }

    private fun List<Pair<Char, Int>>.isExtensibleTo(target: List<Pair<Char, Int>>) = size == target.size &&
            zip(target).all { (a, b) -> a.first == b.first && (a.second == b.second || (a.second < b.second && b.second >= 3)) }
}
