package main

import (
	"sort"
	"strings"
)

func frequencySort(s string) string {
	freq := make(map[string]int)
	for i := 0; i < len(s); i++ {
		freq[string(s[i])]++
	}

	type kv struct {
		Key   string
		Value int
	}

	var arr []kv
	for k, v := range freq {
		arr = append(arr, kv{k, v})
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i].Value > arr[j].Value
	})

	var sb strings.Builder
	for _, a := range arr {
		for i := 0; i < a.Value; i++ {
			sb.WriteString(a.Key)
		}
	}

	return sb.String()
}
