package main

import "sort"

func hIndex(citations []int) int {
	sort.Ints(citations)
	n := len(citations)
	for h := 0; h < n; h++ {
		if citations[h] >= n-h {
			return n - h
		}
	}
	return 0
}