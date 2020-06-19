package main

import (
    "sort"
    "strings"
)

func reorderLogFiles(logs []string) []string {
    n := len(logs)
    letters, digits := make([]string, 0, n), make([]string, 0, n)

    for _, log := range logs {
        firstChar := strings.Split(log, " ")[1][0]
        if '0' <= firstChar && firstChar <= '9' {
            digits = append(digits, log)
        } else {
            letters = append(letters, log)
        }
    }

    sort.Slice(letters, func(i, j int) bool {
        p1, p2 := strings.Index(letters[i], " "), strings.Index(letters[j], " ")
        v1, v2 := letters[i][p1+1:], letters[j][p2+1:]
        if v1 != v2 {
            return v1 < v2
        }
        return letters[i][:p1] < letters[j][:p2]
    })

    return append(letters, digits...)
}