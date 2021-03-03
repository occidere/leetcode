package main

func missingNumber(nums []int) int {
    sum, acc := 0, 0
    for i, n := range nums {
        sum, acc = sum+i+1, acc+n
    }
    return sum - acc
}
