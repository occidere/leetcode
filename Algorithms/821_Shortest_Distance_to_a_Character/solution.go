package main

func shortestToChar(s string, c byte) []int {
	cPos := make([]int, 0)
	for i, ch := range s {
		if byte(ch) == c {
			cPos = append(cPos, i)
		}
	}

	ans := make([]int, len(s))
	for i := 1; i < len(cPos); i++ {
		half := (cPos[i-1] + cPos[i]) >> 1
		for j, k := cPos[i-1]+1, 1; j <= half; j, k = j+1, k+1 {
			ans[j], ans[cPos[i]-k] = k, k
		}
	}

	for i, k := cPos[0]-1, 1; i >= 0; i, k = i-1, k+1 {
		ans[i] = k
	}

	for i, k := cPos[len(cPos)-1]+1, 1; i < len(s); i, k = i+1, k+1 {
		ans[i] = k
	}

	return ans
}