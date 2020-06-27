package main

import "sort"

func partitionLabels(S string) []int {
	rangeMap := make(map[rune][]int)
	for i, s := range S {
		if rangeMap[s] == nil {
			rangeMap[s] = []int{i, i}
		}
		rangeMap[s][1] = i
	}

	ranges := make([][]int, 0, len(rangeMap))
	for _, v := range rangeMap {
		ranges = append(ranges, v)
	}
	sort.Slice(ranges, func(i, j int) bool {
		return ranges[i][0] < ranges[j][0]
	})

	left, right := 0, 0
	p := make([]int, 0, len(ranges))
	for _, lr := range ranges {
		if left > lr[0] || lr[0] > right {
			p = append(p, right-left+1)
			left, right = lr[0], lr[1]
		} else if right < lr[1] {
			right = lr[1]
		}
	}
	return append(p, right-left+1)
}
