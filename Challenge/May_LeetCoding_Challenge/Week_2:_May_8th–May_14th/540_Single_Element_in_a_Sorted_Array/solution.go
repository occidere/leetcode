package main

func singleNonDuplicate(nums []int) int {
    sum := 0
    for i, num := range nums {
        if i%2 == 0 {
            sum += num
        } else {
            sum -= num
        }
    }
    return sum
}
