package main

import (
    "strings"
)

func removeKdigits(num string, k int) string {
    ptr, stk := 0, make([]string, len(num))

    for i := 0; i < len(num); i, ptr = i+1, ptr+1 {
        cur := string(num[i])
        for ; k > 0 && ptr > 0 && stk[ptr-1] > cur; k, ptr = k-1, ptr-1 {
        }
        stk[ptr] = cur
    }

    stk, ptr = stk[0:ptr-k], 0
    for i := 0; i < len(stk) && stk[i] == "0"; i, ptr = i+1, ptr+1 {
    }

    res := strings.Join(stk[ptr:], "")
    if len(res) == 0 {
        return "0"
    } else {
        return res
    }
}
