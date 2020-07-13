package main

func numIdenticalPairs(nums []int) int {
    freq := make(map[int]int)
    for _, n := range nums {
        freq[n]++
    }
    pairs := 0
    for _, v := range freq {
        pairs += v * (v - 1) >> 1
    }
    return pairs
}

func main() {

}
