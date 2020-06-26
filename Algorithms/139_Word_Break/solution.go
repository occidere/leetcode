package main

func wordBreak(s string, wordDict []string) bool {
    dictMap := make(map[string]bool)
    for _, word := range wordDict {
        dictMap[word] = true
    }

    dp := make([]bool, len(s) + 1, len(s) + 1)
    dp[0] = true

    for i := 1; i <= len(s); i++ {
        for j := 0; j < i; j++ {
            if dp[j] && dictMap[s[j:i]] {
                dp[i] = true
                break
            }
        }
    }

    return dp[len(s)]
}

func main() {
    //fmt.Println(wordBreak("applepenapple", []string{"apple", "pen"}))
    //fmt.Println(wordBreak("catsandog", []string{"cats", "dog", "sand", "and", "cat"}))
    //fmt.Println(wordBreak("leetleetcodeleetcodeleet", []string{"leet", "code"}))
    //fmt.Println(wordBreak("a", []string{"leet", "code"}))
    //fmt.Println(wordBreak("cars", []string{"car", "ca", "rs"}))
    //fmt.Println(wordBreak("aaaaaaaaaa",
    //    []string{"a", "aa", "aaa", "aaaa", "aaaaa"}))
}
