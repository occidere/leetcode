package main

func maxUncrossedLines(A []int, B []int) int {
    return lcs(A, B)
}

func lcs(A []int, B []int) int {
    max := func(a int, b int) int {
        if a < b {
            return b
        } else {
            return a
        }
    }

    aLen, bLen := len(A), len(B)

    d := make([][]int, aLen+1)
    for i := range d {
        d[i] = make([]int, bLen+1)
    }

    for i := 1; i <= aLen; i++ {
        for j := 1; j <= bLen; j++ {
            if A[i-1] == B[j-1] {
                d[i][j] = d[i-1][j-1] + 1
            } else {
                d[i][j] = max(d[i][j-1], d[i-1][j])
            }
        }
    }

    return d[aLen][bLen]
}