class Solution {
    fun rotateString(s: String, goal: String) = s.length == goal.length && "$s$s".contains(goal)
}
