from typing import *


class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        cache = {}
        for i, g in enumerate(groupSizes):
            if g not in cache:
                cache[g] = []
            cache[g].append(i)
        
        ans = []
        for length, peoples in cache.items():
            group = []
            for people in peoples:
                group.append(people)
                if len(group) == length:
                    ans.append(group)
                    group = []
        return ans
