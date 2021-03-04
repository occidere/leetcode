import queue
from typing import *


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        courses = [[] for _ in range(numCourses)]
        in_degree = [0 for _ in range(numCourses)]
        for p in prerequisites:
            in_degree[p[0]] += 1
            courses[p[1]].append(p[0])

        q = queue.Queue()
        ans: List[int] = []
        for k, v in enumerate(in_degree):
            if v == 0:
                q.put(k)

        while not q.empty():
            cur: int = q.get()
            ans.append(cur)
            for next_course in courses[cur]:
                in_degree[next_course] -= 1
                if in_degree[next_course] == 0:
                    q.put(next_course)

        return ans if len(ans) == numCourses else []