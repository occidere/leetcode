package main

import "sort"

func canBeEqual(target []int, arr []int) bool {
	sort.Ints(target)
	sort.Ints(arr)
	for i := 0; i < len(arr); i++ {
		if arr[i] != target[i] {
			return false
		}
	}
	return true
}

func main() {
	// 2, 3, 1, 4
	// 2, 1, 3, 4
	// 1, 2, 3, 4
}