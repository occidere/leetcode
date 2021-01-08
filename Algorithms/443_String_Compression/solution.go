package main

import "strconv"

func compress(chars []byte) int {
	k, n := 0, len(chars)
	for i := 0; i < n; {
		cnt, j := 1, i+1
		for ; j < n && chars[i] == chars[j]; j++ {
			cnt++
		}

		chars[k], k = chars[i], k+1
		if cnt > 1 {
			for _, c := range strconv.Itoa(cnt) {
				chars[k], k = byte(c), k+1
			}
		}
		i = j
	}

	return k
}