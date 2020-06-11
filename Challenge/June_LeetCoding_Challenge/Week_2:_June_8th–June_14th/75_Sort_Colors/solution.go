package main

func sortColors(nums []int) {
    // Algorithm of Dutch National Flag Problem by Dijkstra
    // ref: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
    topOfUnder := 0
    topOfMiddle := 0
    botOfUpper := len(nums)
    mid := 1

    for topOfMiddle < botOfUpper {
        if nums[topOfMiddle] < mid {
            swap(&nums, topOfUnder, topOfMiddle)
            topOfUnder++
            topOfMiddle++
        } else if nums[topOfMiddle] > mid {
            botOfUpper--
            swap(&nums, topOfMiddle, botOfUpper)
        } else {
            topOfMiddle++
        }
    }
}

func swap(nums *[]int, i, j int) {
    (*nums)[i], (*nums)[j] = (*nums)[j], (*nums)[i]
}
