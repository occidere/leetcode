package main

func concatenatedBinary(n int) int {
	inf, k, acc := 1000000007, 1, 0
	for i := n; i > 0; i-- {
		for j := i; j > 0; j >>= 1 {
			acc, k = (acc+(k*(j%2))%inf)%inf, (k<<1)%inf
		}
	}
	return acc
}
