package main

type Queue struct {
	queue [][]int
}

func (q *Queue) Offer(pos []int) {
	q.queue = append(q.queue, pos)
}

func (q *Queue) Poll() []int {
	pos := q.queue[0]
	q.queue = q.queue[1:]
	return pos
}

func (q *Queue) IsEmpty() bool {
	return len(q.queue) == 0
}

func orangesRotting(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	q := Queue{}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] >= 2 {
				q.Offer([]int{i, j})
			}
		}
	}

	maxVal := 2
	dx, dy := [4]int{-1, 1, 0, 0}, [4]int{0, 0, -1, 1}
	for !q.IsEmpty() {
		cur := q.Poll()
		for i := 0; i < 4; i++ {
			ax, ay := cur[0]+dx[i], cur[1]+dy[i]
			if inRange(ax, ay, m, n) && canMove(grid[cur[0]][cur[1]], grid[ax][ay]) {
				grid[ax][ay] = grid[cur[0]][cur[1]] + 1
				q.Offer([]int{ax, ay})
				if maxVal < grid[ax][ay] {
					maxVal = grid[ax][ay]
				}
			}
		}
	}

	if isFinished(grid) {
		return maxVal - 2
	}
	return -1
}

func inRange(x, y, m, n int) bool {
	return (0 <= x && x < m) && (0 <= y && y < n)
}

func canMove(cur, next int) bool {
	return next == 1 || (1 < next && cur+1 < next)
}

func isFinished(grid [][]int) bool {
	for _, rows := range grid {
		for _, col := range rows {
			if col == 1 {
				return false
			}
		}
	}
	return true
}