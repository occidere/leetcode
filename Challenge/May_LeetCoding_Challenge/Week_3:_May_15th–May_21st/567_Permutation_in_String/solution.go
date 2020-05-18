package main

func checkInclusion(s1 string, s2 string) bool {
    len1, len2 := len(s1), len(s2)

    if len1 <= len2 {
        buf1, buf2 := [26]int{}, [26]int{}

        for _, ch := range s1 {
            buf1[ch-'a']++
        }

        for i := 0; i < len1; i++ {
            buf2[s2[i]-'a']++
        }

        for left, right := 0, len1; right <= len2; left, right = left+1, right+1 {
            if isValid(s1, buf1, buf2) {
                return true
            }
            buf2[s2[left]-'a']--
            if right < len2 {
                buf2[s2[right]-'a']++
            }
        }
    }

    return false
}

func isValid(s1 string, buf1 [26]int, buf2 [26]int) bool {
    for _, s := range s1 {
        if buf1[s-'a'] != buf2[s-'a'] {
            return false
        }
    }
    return true
}
