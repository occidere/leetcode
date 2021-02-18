package main

func numberOfArithmeticSlices(A []int) int {
	acc, cur := 0, 0

	for i := 2; i < len(A); i++ {
		if A[i-1]-A[i-2] == A[i]-A[i-1] {
			cur++
			acc += cur
		} else {
			cur = 0
		}
	}

	return acc
}
