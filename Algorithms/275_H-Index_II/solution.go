package main

import (
	"fmt"
)

func hIndex(citations []int) int {
	n := len(citations)
	left, right := 0, n-1
	for left <= right {
		mid := (left + right) >> 1
		if citations[mid] >= (n - mid) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return n - left
}

func main() {
	//fmt.Println(hIndex([]int{0, 1, 3, 5, 6}))
	//fmt.Println(hIndex([]int{0, 1, 3, 5, 5, 5, 5, 5, 5, 6}))
	fmt.Println(hIndex([]int{0, 1, 1, 4, 6, 7}))
	//fmt.Println(hIndex([]int{100}))
}
