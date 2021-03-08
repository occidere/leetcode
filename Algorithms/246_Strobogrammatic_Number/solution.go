package main

func isStrobogrammatic(num string) bool {
    buf := make([]int32, len(num))
    for i, n := range num {
        if n == '0' || n == '1' || n == '8' {
            buf[i] = n
        } else if n == '6' {
            buf[i] = '9'
        } else if n == '9' {
            buf[i] = '6'
        } else {
            return false
        }
    }

    for i := 0; i < len(num); i++ {
        if int32(num[i]) != buf[len(num)-1-i] {
            return false
        }
    }

    return true
}
