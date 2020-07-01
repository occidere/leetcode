package main

import (
    "fmt"
    "regexp"
    "strings"
)

func mostCommonWord(paragraph string, banned []string) string {
    notAlphabet, _ := regexp.Compile("[^a-zA-Z]")
    words := strings.Split(notAlphabet.ReplaceAllString(paragraph, " "), " ")

    ban, freq := make(map[string]bool), make(map[string]int)
    for _, b := range banned {
        ban[strings.ToLower(notAlphabet.ReplaceAllString(b, ""))] = true
    }

    maxWord, maxCount := "", 0
    for _, w := range words {
        if len(w) > 0 {
            lowerWord := strings.ToLower(notAlphabet.ReplaceAllString(w, ""))
            if !ban[lowerWord] {
                freq[lowerWord]++
                if freq[lowerWord] > maxCount {
                    maxWord, maxCount = lowerWord, freq[lowerWord]
                }
            }
        }
    }

    return maxWord
}

func main() {
    fmt.Println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", []string{"hit"}))
    //fmt.Println(mostCommonWord("a, a, a, a, b,b,b,c, c", []string{"a"}))
}
