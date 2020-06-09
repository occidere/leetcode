package main

import "fmt"

func oddCells(n int, m int, indices [][]int) int {
	mat := make([][]int, n, n)
	for i := 0; i < n; i++ {
		mat[i] = make([]int, m, m)
	}

	for _, rc := range indices {
		for i := 0; i < m; i++ {
			mat[rc[0]][i]++
		}
		for i := 0; i < n; i++ {
			mat[i][rc[1]]++
		}
	}

	odd := 0
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			odd += mat[i][j] % 2
		}
	}

	return odd
}

func main() {
	fmt.Println(oddCells(2, 2, [][]int{{0, 0}, {1, 1}}))
}

/*
Hi Clark,

I'm sorry for the late reply.
Thank you for a great opportunity to introduce. It was a great honor for me.

But after a few days of serious thought, I realized that I was not ready to take this opportunity.
Thank you again for proposing this great opportunity. If you have a good chance next time, can you make me a offer again comfortably?

Sincerely,
 */