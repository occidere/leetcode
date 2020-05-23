package main

func intervalIntersection(A [][]int, B [][]int) [][]int {
	var ins [][]int

	for i, j := 0, 0; i < len(A) && j < len(B); {
		lo, hi := Max(A[i][0], B[j][0]), Min(A[i][1], B[j][1])

		if lo <= hi {
			ins = append(ins, []int{lo, hi})
		}

		if A[i][1] < B[j][1] {
			i++
		} else {
			j++
		}
	}

	return ins
}

func Max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func Min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}