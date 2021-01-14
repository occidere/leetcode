package main

func max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}

func minOperations(nums []int, x int) int {
	target := -x
	for _, n := range nums {
		target += n
	}
	if target == 0 {
		return len(nums)
	}

	sumMap := make(map[int]int)
	sumMap[0] = -1
	prefixSum, maxSubArrLen := 0, -1
	for i, n := range nums {
		prefixSum += n
		if pos, exist := sumMap[prefixSum-target]; exist {
			maxSubArrLen = max(maxSubArrLen, i-pos)
		}
		sumMap[prefixSum] = i
	}

	if maxSubArrLen == -1 {
		return -1
	} else {
		return len(nums) - maxSubArrLen
	}
}
