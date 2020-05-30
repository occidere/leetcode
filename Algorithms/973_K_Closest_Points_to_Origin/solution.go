package main

import "sort"

type DistCoord struct {
	Dist  int
	Coord []int
}

func calcEuclideanDist(p []int) int {
	return p[0]*p[0] + p[1]*p[1]
}

func kClosest(points [][]int, K int) [][]int {
	n := len(points)
	distCoords := make([]DistCoord, n, n)

	for i := 0; i < n; i++ {
		distCoords[i] = DistCoord{calcEuclideanDist(points[i]), points[i]}
	}

	sort.Slice(distCoords, func(i, j int) bool {
		return distCoords[i].Dist < distCoords[j].Dist
	})

	ans := make([][]int, K, K)
	for i := 0; i < K; i++ {
		ans[i] = distCoords[i].Coord
	}

	return ans
}