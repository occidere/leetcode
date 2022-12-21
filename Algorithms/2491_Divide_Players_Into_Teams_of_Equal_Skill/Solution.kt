/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-20
 */
class Solution {
    fun dividePlayers(skill: IntArray) = skill.sorted().let { sortedSkill ->
        (0 until skill.size.shr(1)).asSequence()
            .map { sortedSkill[it].toLong() to sortedSkill[skill.size - 1 - it].toLong() }
            .map { (x, y) -> Pair(x + y, x * y) }
            .toList()
            .run { if (distinctBy { it.first }.size != 1) -1 else map { it.second }.sum() }
    }
}
