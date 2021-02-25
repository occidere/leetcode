package main

import "sort"

func findUnsortedSubarray(nums []int) int {
	n := len(nums)
	sortedNums := make([]int, n)
	copy(sortedNums, nums)
	sort.Ints(sortedNums)

	a, b := 0, 0
	for i := 0; i < n; i++ {
		if nums[i] != sortedNums[i] {
			a = i
			break
		}
	}

	for i := n - 1; i >= 0; i-- {
		if nums[i] != sortedNums[i] {
			b = i
			break
		}
	}

	if a == 0 && b == 0 {
		return 0
	}
	return b - a + 1
}