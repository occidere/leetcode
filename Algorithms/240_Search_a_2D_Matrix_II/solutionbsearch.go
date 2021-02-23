package main

func bSearch(arr []int, target int) bool {
	left, right := 0, len(arr)-1
	for ; left <= right; {
		mid := (left + right) >> 1
		if arr[mid] < target {
			left = mid + 1
		} else if arr[mid] > target {
			right = mid - 1
		} else {
			return true
		}
	}
	return false
}

func searchMatrix(matrix [][]int, target int) bool {
	for _, mat := range matrix {
		if bSearch(mat, target) {
			return true
		}
	}
	return false
}