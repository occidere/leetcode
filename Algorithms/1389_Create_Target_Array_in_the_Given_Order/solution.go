package main

func createTargetArray(nums []int, index []int) []int {
	n := len(nums)
	ans := make([]int, n, n)
	for i := 0; i < n; i++ {
		p := index[i]
		for j := i; j > p; j-- {
			ans[j] = ans[j-1]
		}
		ans[p] = nums[i]
	}
	return ans
}