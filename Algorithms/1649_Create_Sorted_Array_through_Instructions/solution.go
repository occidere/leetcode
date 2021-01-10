package main

import (
	"math"
	"sort"
)

type SegmentTree struct {
	tree []int
}

// 노드번호 (1부터 시작), 배열 시작 (0부터), 배열 끝, 배열 범위 시작 (0부터), 배열 범위 끝
func (st *SegmentTree) RangeSum(nodeIdx int, start int, end int, left int, right int) int {
	if left > end || right < start {
		return 0
	} else if left <= start && end <= right {
		return st.tree[nodeIdx]
	} else {
		mid := (start + end) >> 1
		return st.RangeSum(nodeIdx<<1, start, mid, left, right) +
			st.RangeSum((nodeIdx<<1)+1, mid+1, end, left, right)
	}
}

// 노드번호 (1부터 시작), 배열 시작 (0부터), 배열 끝, 배열 인덱스
func (st *SegmentTree) Update(nodeIdx int, start int, end int, idx int) {
	if start <= idx && idx <= end {
		st.tree[nodeIdx] += 1
		if start != end {
			mid := (start + end) >> 1
			st.Update(nodeIdx<<1, start, mid, idx)
			st.Update((nodeIdx<<1)+1, mid+1, end, idx)
		}
	}
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

func createSortedArray(instructions []int) int {
	// slice 정렬 후 인덱스 매핑
	sorted := make([]int, len(instructions))
	copy(sorted, instructions)
	sort.Ints(sorted)
	i, idxMap := 0, make(map[int]int)
	for _, ins := range sorted {
		if _, exist := idxMap[ins]; !exist {
			idxMap[ins] = i
			i++
		}
	}

	// Segment Tree 생성
	size := len(instructions)
	tSize := 1 << (1 + int(math.Ceil(math.Log2(float64(size)))))
	st := SegmentTree{make([]int, tSize, tSize)}

	acc, inf := 0, 1000000007
	for _, ins := range instructions {
		// 구간합 중 최솟값 찾아 누적
		lSum, rSum := 0, 0
		left, right := idxMap[ins]-1, idxMap[ins]+1
		if 0 <= left {
			lSum = st.RangeSum(1, 0, size-1, 0, left)
		}
		if right < size {
			rSum = st.RangeSum(1, 0, size-1, right, size-1)
		}
		acc = ((min(lSum, rSum) % inf) + acc) % inf

		// 등장 횟수 업데이트
		st.Update(1, 0, size-1, idxMap[ins])
	}

	return acc
}
