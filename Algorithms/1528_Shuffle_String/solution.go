package main

func restoreString(s string, indices []int) string {
	s2 := make([]byte, len(s), len(s))
	for i, idx := range indices {
		s2[idx] = s[i]
	}
	return string(s2)
}