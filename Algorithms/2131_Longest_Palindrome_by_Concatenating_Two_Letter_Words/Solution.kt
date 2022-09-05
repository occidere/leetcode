import kotlin.math.min

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-05
 */
class Solution {
    fun longestPalindrome(words: Array<String>) = words.groupBy { it }
        .mapValues { it.value.size }
        .toMutableMap()
        .withDefault { 0 }
        .let { wordMap ->
            var len = 0
            wordMap.keys.toList().forEach { key ->
                val pairKey = key.reversed()
                val matchCount = min(wordMap.getValue(key), wordMap.getValue(pairKey))
                    .shr(if (key == pairKey) 1 else 0)
                len += matchCount.shl(2)
                wordMap[key] = wordMap.getValue(key) - matchCount
                wordMap[pairKey] = wordMap.getValue(pairKey) - matchCount
            }
            len + if (wordMap.any { (k, v) -> 0 < v && k[0] == k[1] }) 2 else 0
        }
}
