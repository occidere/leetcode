package main

func possibleBipartition(N int, dislikes [][]int) bool {
    graph := make(map[int][]int)
    for _, d := range dislikes {
        from, to := d[0]-1, d[1]-1
        graph[from], graph[to] = append(graph[from], to), append(graph[to], from)
    }

    partitions := make([]int, N, N)
    for i := 0; i < N; i++ {
        if partitions[i] == 0 && !isPossible(i, graph, partitions, 1) {
            return false
        }
    }

    return true
}

func isPossible(cur int, graph map[int][]int, partitions []int, partitionNum int) bool {
    partitions[cur] = partitionNum
    for _, next := range graph[cur] {
        /* False condition: */
        // 1. Already visit but had contradict partition num.
        // 2. Not visit yet but contradiction occurred after visit all connection.
        if partitions[next] == partitionNum || (partitions[next] == 0 && !isPossible(next, graph, partitions, -partitionNum)) {
            return false
        }
    }
    return true
}
