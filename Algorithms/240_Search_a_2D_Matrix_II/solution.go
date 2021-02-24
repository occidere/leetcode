package main

func searchMatrix(matrix [][]int, target int) bool {
	row, col := len(matrix)-1, 0
	for ; 0 <= row && col < len(matrix[0]); {
		cur := matrix[row][col]
		if cur < target {
			col++
		} else if cur > target {
			row--
		} else {
			return true
		}
	}

	return false
}
