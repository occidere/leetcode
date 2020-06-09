package main

import "fmt"

func isSubsequence(s string, t string) bool {
	pos := make(map[byte][]int)
	for i := 0; i < len(t); i++ {
		pos[t[i]] = append(pos[t[i]], i)
	}

	for i, pre := 0, -1; i < len(s); i++ {
		p := getValidPos(pos, s[i], pre)
		if p != -1 {
			pre = p
		} else {
			return false
		}
	}

	return true
}

func getValidPos(pos map[byte][]int, b byte, curPos int) int {
	for _, p := range pos[b] {
		if p > curPos {
			return p
		}
	}
	return -1
}

func main() {
	fmt.Println(isSubsequence("aec", "abcde"))
}
