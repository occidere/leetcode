package main

import (
	"fmt"
	"sort"
)

func largestDivisibleSubset(nums []int) []int {
	sort.Ints(nums)

	n := len(nums)
	count, trace := make([]int, n, n), make([]int, n, n)
	max, idx := 0, -1

	for i := 0; i < n; i++ {
		count[i], trace[i] = 1, -1
		for j := i - 1; j >= 0; j-- {
			if nums[i] % nums[j] == 0 && count[j]+1 > count[i] {
				count[i], trace[i] = count[j]+1, j
			}
		}
		if count[i] > max {
			max, idx = count[i], i
		}
	}

	ans := make([]int, 0, n)
	for idx != -1 {
		ans, idx = append(ans, nums[idx]), trace[idx]
	}

	return ans
}

func main() {
	fmt.Println(largestDivisibleSubset([]int{1, 2, 4, 8}))
}
