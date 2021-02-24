package main

func brokenCalc(x int, y int) int {
	cnt := 0
	for ; x < y; cnt++ {
		if y%2 == 1 {
			y++
		} else {
			y >>= 1
		}
	}
	return cnt + x - y
}
