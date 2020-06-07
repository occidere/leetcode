package main

func change(amount int, coins []int) int {
	d := [5001]int{1}
	for _, coin := range coins {
		for i := coin; i <= amount; i++ {
			d[i] += d[i-coin]
		}
	}
	return d[amount]
}