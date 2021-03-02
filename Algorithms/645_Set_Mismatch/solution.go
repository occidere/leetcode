package main

func findErrorNums(nums []int) []int {
    freq := make(map[int]int)
    for i := 1; i <= len(nums); i++ {
        freq[i] = 1
    }
    for _, n := range nums {
        freq[n]--
    }
    dup, lost := 0, 0
    for k, v := range freq {
        if v == -1 {
            dup = k
        } else if v == 1 {
            lost = k
        }
    }
    return []int{dup, lost}
}
