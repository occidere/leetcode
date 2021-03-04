from typing import *


class Solution:
    READY, PROCESSING, FINISHED = 1, 2, 3

    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        courses = [[] for _ in range(numCourses)]
        for p in prerequisites:
            courses[p[1]].append(p[0])

        colors = [Solution.READY for _ in range(numCourses)]
        stk: List[int] = []
        is_possible = True

        def dfs(course: int) -> None:
            nonlocal is_possible
            if is_possible:
                colors[course] = Solution.PROCESSING
                for next_course in courses[course]:
                    if colors[next_course] == Solution.READY:
                        dfs(next_course)
                    elif colors[next_course] == Solution.PROCESSING:  # Cycle detected!
                        is_possible = False

            colors[course] = Solution.FINISHED
            stk.append(course)

        for i in range(numCourses):
            if colors[i] == Solution.READY:
                dfs(i)

        return reversed(stk) if is_possible else []
