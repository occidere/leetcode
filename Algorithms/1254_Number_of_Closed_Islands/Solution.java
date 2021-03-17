import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[][] grid;
    private int m, n;
    private final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int numberOfIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    numberOfIsland += bfs(i, j);
                }
            }
        }

        return numberOfIsland;
    }

    private int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        int island = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            grid[p.x][p.y] = 1;

            for (int i = 0; i < 4; i++) {
                int ax = p.x + dx[i], ay = p.y + dy[i];
                if (inRange(ax, ay)) {
                    if (grid[ax][ay] == 0) {
                        q.offer(new Point(ax, ay));
                    }
                } else {
                    island = 0; // Reach edge of grid
                }
            }
        }

        return island;
    }

    private boolean inRange(int x, int y) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }
}