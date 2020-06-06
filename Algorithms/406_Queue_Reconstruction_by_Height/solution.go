package main

import (
	"sort"
)

func reconstructQueue(people [][]int) [][]int {
	sort.Slice(people, func(i, j int) bool {
		if people[i][0] == people[j][0] {
			return people[i][1] < people[j][1]
		}
		return people[i][0] > people[j][0]
	})

	res := make([][]int, 0, len(people))
	for _, p := range people {
		Insert(&res, p, p[1])
	}

	return res
}

func Insert(arr *[][]int, a []int, idx int) {
	*arr = append(*arr, nil)
	for i := len(*arr) - 1; i > idx; i-- {
		(*arr)[i] = (*arr)[i-1]
	}
	(*arr)[idx] = a
}