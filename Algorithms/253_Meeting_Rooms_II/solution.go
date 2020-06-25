package main

import "sort"

// 현재 우측점을 기준으로 최대 겹치는 부분을 탐색
func minMeetingRooms(intervals [][]int) int {
    starts, ends := make([]int, 0, len(intervals)), make([]int, 0, len(intervals))
    for _, itv := range intervals {
        starts, ends = append(starts, itv[0]), append(ends, itv[1])
    }
    sort.Ints(starts)
    sort.Ints(ends)

    overlap, endPos := 0, 0
    for _, start := range starts {
        if start < ends[endPos] {
            overlap++
        } else {
            endPos++
        }
    }

    return overlap
}
