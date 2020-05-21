package main

/* Inspired by https://youtu.be/PlZDg1VoKDg */

func min(a int, b int, c int) int {
    m := a
    if b < m {
        m = b
    }
    if c < m {
        m = c
    }
    return m
}

func countSquares(matrix [][]int) int {
    cnt, rows, cols := 0, len(matrix), len(matrix[0])

    for i := 0; i < rows; i++ {
        cnt += matrix[i][0]
    }
    for i := 1; i < cols; i++ {
        cnt += matrix[0][i]
    }

    for i := 1; i < rows; i++ {
        for j := 1; j < cols; j++ {
            if matrix[i][j] == 1 {
                matrix[i][j] += min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1])
                cnt += matrix[i][j]
            }
        }
    }

    return cnt
}
