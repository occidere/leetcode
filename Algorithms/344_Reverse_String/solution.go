package main

import "fmt"

func reverseString(s []byte) {
    for i := 0; i < len(s)>>1; i++ {
        s[i], s[len(s)-i-1] = s[len(s)-i-1], s[i]
    }
}

func main() {
    s := []byte{'a', 'b', 'c', 'd', 'e'}
    reverseString(s)
    fmt.Println(s)
}
