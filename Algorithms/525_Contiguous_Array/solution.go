package main

func findMaxLength(nums []int) int {
    acc, maxLen := -1, 0
    posByVal, contains := map[int]int{acc: 0}, map[int]bool{acc: true}

    for i := 1; i <= len(nums); i++ {
        cur := nums[i-1]
        if cur == 1 {
            acc++
        } else {
            acc--
        }

        if contains[acc] {
            curLen := i - posByVal[acc]
            if maxLen < curLen {
                maxLen = curLen
            }
        } else {
            posByVal[acc], contains[acc] = i, true
        }
    }

    return maxLen
}
