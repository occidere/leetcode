package main

func p(n int) int {
	k := 0
	for i := n - 1; i > 0; i-- {
		k += i
	}
	return k
}

func numPairsDivisibleBy60(time []int) int {
	rem := make([]int, 61, 61)
	for _, t := range time {
		rem[t%60]++
	}

	acc := 0
	for i := 1; i < 30; i++ {
		acc += rem[i] * rem[60-i]
	}

	return p(rem[0]) + acc + p(rem[30])
}