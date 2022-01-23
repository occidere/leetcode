class Solution {
    fun rankTeams(votes: Array<String>) = votes.flatMap { vote ->
        vote.indices.map { Team(vote[it]).apply { addRank(it) } }
    }.groupBy { it.name }
        .values
        .map { it.reduce { acc, team -> acc + team } }
        .sorted()
        .map { it.name }
        .joinToString("")

    private class Team(val name: Char) : Comparable<Team> {

        private val ranks: IntArray = IntArray(26) { 0 }

        fun addRank(rank: Int) {
            ++ranks[rank]
        }

        operator fun plus(other: Team): Team {
            if (name != other.name) {
                throw IllegalArgumentException("Team name is not equal")
            }
            return Team(name).also { newTeam ->
                0.until(26).forEach {
                    newTeam.ranks[it] += this.ranks[it] + other.ranks[it]
                }
            }
        }

        override fun compareTo(other: Team): Int {
            for (i in 0 until 26) {
                if (ranks[i] != other.ranks[i]) {
                    return other.ranks[i] - ranks[i]
                }
            }
            return name - other.name
        }
    }
}
