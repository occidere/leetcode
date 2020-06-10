package main

import "fmt"

func longestPalindrome(s string) string {
    n := len(s)
    d := make([][]bool, n, n)

    ans := ""
    for left := n - 1; left >= 0; left-- {
        d[left] = make([]bool, n, n)
        for right := left; right < n; right++ {
            // 길이가 2 이하면 단순 비교, 초과면 substring(left+1, right-1) 또한 팰린드롬 인지도 확인
            d[left][right] = s[left] == s[right] && (right-left < 3 || d[left+1][right-1])

            if d[left][right] && (right-left+1 > len(ans)) {
                ans = s[left : right+1]
            }
        }
    }

    return ans
}

func main() {
    fmt.Println(longestPalindrome(""))
}
