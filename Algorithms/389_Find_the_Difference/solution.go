package main

func findTheDifference(s string, t string) byte {
	freq := [26]int{0}

	for _, v := range s {
		freq[v - 'a'] += 1
	}
	for _, v := range t {
		freq[v - 'a'] -= 1
	}

	for k, v := range freq {
		if v != 0 {
			return byte(k + 'a')
		}
	}
	return 0
}
