package main

import "fmt"

type Queue struct {
    queue [][]int
}

func (q *Queue) Offer(conn []int) {
    q.queue = append(q.queue, conn)
}

func (q *Queue) Poll() []int {
    conn := q.queue[0]
    q.queue = q.queue[1:]
    return conn
}

func (q *Queue) IsEmpty() bool {
    return len(q.queue) == 0
}

func criticalConnections(n int, connections [][]int) [][]int {
    indegree := make([]int, n, n)
    for _, conn := range connections {
        indegree[conn[0]]++
        indegree[conn[1]]++
    }

    critical := make([][]int, 0, n)
    for _, conn := range connections {
        if indegree[conn[0]] == 1 || indegree[conn[1]] == 1 {
            critical = append(critical, conn)
        }
    }

    return critical
}

func main() {
    //res := criticalConnections(4, [][]int{{0, 1}, {1, 2}, {2, 0}, {1, 3}})
    res := criticalConnections(6, [][]int{{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}, {4, 5}, {5, 3}})
    for _, conn := range res {
        fmt.Println(conn)
    }
}
