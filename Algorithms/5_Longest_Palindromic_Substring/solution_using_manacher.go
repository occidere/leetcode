package main

import "strings"

func longestPalindrome(s string) string {
    if s == "" {
        return ""
    }

    s = "." + strings.Join(strings.Split(s, ""), ".") + "."
    n := len(s)
    a := make([]int, n, n)
    maxPos := 0

    r, p := 0, 0
    for i := 0; i < n; i++ {
        if i <= r {
            a[i] = Min(a[2*p-i], r-i)
        }

        for 0 <= i-a[i]-1 && i+a[i]+1 < n && s[i-a[i]-1] == s[i+a[i]+1] {
            a[i]++
        }

        if r < i+a[i] {
            r, p = i+a[i], i
        }

        if a[maxPos] < a[i] {
            maxPos = i
        }
    }

    return strings.Replace(s[maxPos-a[maxPos]:maxPos+a[maxPos]+1], ".", "", -1)
}

func Min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
