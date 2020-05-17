package main

func findAnagrams(s string, p string) []int {
	isAnagram := func(pFreq map[string]int, sFreq map[string]int) bool {
		for k, v := range sFreq {
			if pFreq[k] != v {
				return false
			}
		}
		return true
	}

	var res []int
	pLen, sLen := len(p), len(s)
	pFreq, sFreq := make(map[string]int), make(map[string]int)

	if sLen > 0 && sLen >= pLen {
		for _, pat := range p {
			pFreq[string(pat)]++
		}

		i, j := 0, 0
		for ; j < pLen; j++ {
			sFreq[string(s[j])]++
		}

		for ; j <= sLen; i, j = i+1, j+1 {
			if isAnagram(pFreq, sFreq) {
				res = append(res, i)
			}
			sFreq[string(s[i])]--
			if j < sLen {
				sFreq[string(s[j])]++
			}
		}
	}

	return res
}