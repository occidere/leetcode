package main

func findPeakElement(nums []int) int {
	size := len(nums)
	if size == 1 || nums[0] > nums[1] {
		return 0
	} else if nums[size-2] < nums[size-1] {
		return size - 1
	}

	for i := 1; i < size-1; i++ {
		if nums[i-1] < nums[i] && nums[i] > nums[i+1] {
			return i
		}
	}
	return 0
}