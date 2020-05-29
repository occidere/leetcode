package main

type Queue struct {
	nums []int
}

func (q *Queue) Offer(num int) {
	q.nums = append(q.nums, num)
}

func (q *Queue) Poll() int {
	n := q.nums[0]
	q.nums = q.nums[1:]
	return n
}

func (q *Queue) Size() int {
	return len(q.nums)
}

func (q *Queue) isEmpty() bool {
	return q.Size() == 0
}

func canFinish(numCourses int, prerequisites [][]int) bool {
	graph := make([][]int, numCourses, numCourses)
	indegree := make([]int, numCourses, numCourses)

	for _, p := range prerequisites {
		from, to := p[0], p[1]
		graph[from] = append(graph[from], to)
		indegree[to]++
	}

	return topologicalSort(graph, indegree, numCourses)
}

func topologicalSort(graph [][]int, indegree []int, numCourses int) bool {
	searchQ, resultQ := Queue{}, Queue{}
	for i := 0; i < numCourses; i++ {
		if indegree[i] == 0 {
			searchQ.Offer(i)
		}
	}

	for ; !searchQ.isEmpty(); {
		zeroIndegreeNode := searchQ.Poll()
		resultQ.Offer(zeroIndegreeNode)

		for _, next := range graph[zeroIndegreeNode] {
			indegree[next]--
			if indegree[next] == 0 {
				searchQ.Offer(next)
			}
		}
	}

	return resultQ.Size() == numCourses
}