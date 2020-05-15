package main

import "math"

func max(a int, b int) int {
    if a < b {
        return b
    } else {
        return a
    }
}

func min(a int, b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}

func maxSubarraySumCircular(A []int) int {
    curMax, curMin, total := 0, 0, 0
    maxSum, minSum := math.MinInt32, math.MaxInt32

    for _, a := range A {
        curMax, curMin = max(curMax+a, a), min(curMin+a, a)
        maxSum, minSum = max(maxSum, curMax), min(minSum, curMin)
        total += a
    }

    if maxSum > 0 {
        return max(maxSum, total-minSum)
    } else {
        return maxSum
    }
}
