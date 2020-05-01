# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):


class Solution:
    def firstBadVersion(self, n):
        left, right = 1, n
        first_bad = n

        while left <= right:
            mid = (left + right) // 2
            is_bad = isBadVersion(mid)

            if is_bad:
                right, first_bad = mid - 1, min(first_bad, mid)
            else:
                left = mid + 1

        return first_bad
