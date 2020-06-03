package main

import "sort"

func twoCitySchedCost(costs [][]int) int {
	sort.Slice(costs, func(i, j int) bool {
		return costs[i][0]-costs[i][1] < costs[j][0]-costs[j][1]
	})

	minCost, half := 0, len(costs)>>1
	for i := 0; i < len(costs); i++ {
		minCost += costs[i][i/half]
	}
	return minCost
}
