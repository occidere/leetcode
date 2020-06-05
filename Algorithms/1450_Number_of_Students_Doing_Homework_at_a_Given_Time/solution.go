package main

func busyStudent(startTime []int, endTime []int, queryTime int) int {
    ans := 0
    for i := 0; i < len(startTime); i++ {
        if startTime[i] <= queryTime && queryTime <= endTime[i] {
            ans++
        }
    }
    return ans
}