package main

func numTrees(n int) int {
    d := make([]int, n+1, n+1)
    d[0] = 1
    return dp(n, d)
}

func dp(n int, d []int) int {
    if d[n] == 0 {
        for i := 0; i < n; i++ {
            d[n] += d[i] * dp(n-i-1, d)
        }
    }
    return d[n]
}