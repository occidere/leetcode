package main

var (
    q      [][]int
    dx, dy [4]int
)

func solve(board [][]byte) {
    if board == nil || len(board) == 0 {
        return
    }

    q = [][]int{}
    m, n := len(board), len(board[0])
    dx, dy = [4]int{-1, 1, 0, 0}, [4]int{0, 0, -1, 1}

    for i := 0; i < m; i++ {
        if board[i][0] == 'O' {
            move(board, i, 0)
        }
        if board[i][n-1] == 'O' {
            move(board, i, n-1)
        }
    }

    for j := 1; j < n-1; j++ {
        if board[0][j] == 'O' {
            move(board, 0, j)
        }
        if board[m-1][j] == 'O' {
            move(board, m-1, j)
        }
    }

    for i := 1; i < m-1; i++ {
        for j := 1; j < n-1; j++ {
            board[i][j] = 'X'
        }
    }

    for _, p := range q {
        board[p[0]][p[1]] = 'O'
    }
}

func move(board [][]byte, x, y int) {
    board[x][y] = 'X'
    q = append(q, []int{x, y})
    for i := 0; i < 4; i++ {
        ax, ay := x+dx[i], y+dy[i]
        if inRange(ax, ay, len(board), len(board[0])) && board[ax][ay] == 'O' {
            move(board, ax, ay)
        }
    }
}

func inRange(x, y, m, n int) bool {
    return (0 <= x && x < m) && (0 <= y && y < n)
}
