package main

import (
    "strconv"
    "strings"
)

func validIPAddress(IP string) string {
    if isIPv4(IP) {
        return "IPv4"
    } else if isIPv6(IP) {
        return "IPv6"
    }
    return "Neither"
}

func isIPv4(ip string) bool {
    groups := strings.Split(ip, ".")
    if len(groups) != 4 {
        return false
    }

    for _, fragment := range groups {
        fLen := len(fragment)
        if fLen == 0 || fLen > 3 {
            return false
        } else if fLen != 1 && fragment[0] == '0' {
            return false
        } else if '0' > fragment[0] || fragment[0] > '9' {
            return false
        }

        num, err := strconv.Atoi(fragment)
        if err != nil || (0 > num || num > 255) {
            return false
        }
    }

    return true
}

func isIPv6(ip string) bool {
    groups := strings.Split(ip, ":")
    if len(groups) != 8 {
        return false
    }

    for _, fragment := range groups {
        fLen := len(fragment)
        if fLen == 0 || fLen > 4 {
            return false
        }

        for _, s := range fragment {
            if !(('a' <= s && s <= 'f') || ('A' <= s && s <= 'F') || ('0' <= s && s <= '9')) {
                return false
            }
        }
    }

    return true
}