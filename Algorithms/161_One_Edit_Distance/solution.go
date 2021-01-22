package main

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func isOneEditDistance(s string, t string) bool {
	sLen, tLen := len(s), len(t)
	if s == t || abs(sLen-tLen) > 1 {
		return false
	}

	i, j, diff := 0, 0, 0
	for ; i < sLen && j < tLen; {
		if diff > 1 {
			return false
		}

		if s[i] != t[j] {
			diff++
			if sLen < tLen {
				j++ // delete at j in t
				continue
			} else if sLen > tLen {
				i++ // delete at i in s
				continue
			}
		}
		i++
		j++
	}

	return diff < 2
}