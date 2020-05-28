package main

func countBits(num int) []int {
    d := make([]int, num+1, num+1)

    if num > 0 {
        d[1] = 1
        nSquareNum := 1
        for i := 2; i <= num; i++ {
            if i%2 == 0 {
                nSquareNum = func(n int, nSquareNum int) int {
                    for ; nSquareNum <= n; nSquareNum <<= 1 {}
                    return nSquareNum >> 1
                }(i, nSquareNum)
            }
            d[i] = d[i-nSquareNum] + 1
        }
    }

    return d
}