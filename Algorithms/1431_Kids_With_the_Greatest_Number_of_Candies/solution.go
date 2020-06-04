package main

func Max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}

func kidsWithCandies(candies []int, extraCandies int) []bool {
	ans := make([]bool, len(candies), len(candies))

	max := 0
	for _, c := range candies {
		max = Max(max, c)
	}

	for i, c := range candies {
		if c + extraCandies >= max {
			ans[i] = true
		}
	}

	return ans
}