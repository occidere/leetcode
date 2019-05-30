class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area, l, r = 0, 0, len(height) - 1
        while l < r:
            max_area = max(max_area, (r - l) * min(height[l], height[r]))
            l, r = (l + 1, r) if height[l] < height[r] else (l, r - 1)
        return max_area
