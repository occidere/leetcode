package main

func countCornerRectangles(grid [][]int) int {
	acc := 0
	m, n := len(grid), len(grid[0])

	for i := 0; i < m-1; i++ {
		for j := i + 1; j < m; j++ {
			cnt := 0
			for k := 0; k < n; k++ {
				cnt += grid[i][k] & grid[j][k] // count vertical line of rectangle (both 1)
			}
			acc += (cnt * (cnt - 1)) >> 1 // mathematical formula
		}
	}

	return acc
}
