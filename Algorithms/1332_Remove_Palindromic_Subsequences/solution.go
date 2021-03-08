package main

func removePalindromeSub(s string) int {
    siz, half := len(s), len(s)>>1
    freq, isPal := [2]int{0, 0}, true

    for i := 0; i < half; i++ {
        x, y := s[i]-'a', s[siz-i-1]-'a'
        if x != y {
            isPal = false
        }
        freq[x]++
        freq[y]++
    }

    if siz%2 == 1 {
        freq[s[half]-'a']++
    }

    if freq[0]+freq[1] == 0 {
        return 0
    } else if isPal || freq[0] == 0 || freq[1] == 0 {
        return 1
    } else {
        return 2
    }
}
