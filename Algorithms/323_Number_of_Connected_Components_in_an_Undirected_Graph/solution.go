package main

func find(parent []int, x int) int {
	if x != parent[x] {
		parent[x] = find(parent, parent[x])
	}
	return parent[x]
}

func countComponents(n int, edges [][]int) int {
	parent := make([]int, n, n)
	for i := 0; i < n; i++ {
		parent[i] = i
	}

	components := n
	for _, e := range edges {
		p1, p2 := find(parent, e[0]), find(parent, e[1])
		if p1 != p2 {
			parent[p1] = p2
			components--
		}
	}

	return components
}

