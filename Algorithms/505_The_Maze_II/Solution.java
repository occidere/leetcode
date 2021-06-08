import java.util.*;

/**
 * Approach: 일단 현재 방향에서 어디까지 갈 수 있는지(벽에 닿을 때 까지) 체크.
 *     이후 (현재 위치 + 이동거리 < 최대한 이동한 곳까지의 비용) 인 경우 비용 갱신 후 이동하고 dfs 또 실행.
 *         포인트는 모든 costs 의 값을 갱신하는게 아니라 이동할 수 있는 마지막 위치 (벽 닿기 직전) 만 갱신하는 것.
 *             이렇게 닿을 수 있는 마지막 위치만 갱신하면 자연스럽게 goal 이 중간에 있는 경우도 해결됨
 *             */
class Solution {
    private int m, n;
    private int[][] costs;
    private int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        costs = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(costs[i], 0x3f3f3f3f);
        }
        costs[start[0]][start[1]] = 0;
        dfs(maze, start[0], start[1]);

        return costs[destination[0]][destination[1]] != 0x3f3f3f3f ? costs[destination[0]][destination[1]] : -1;
    }

    private void dfs(int[][] maze, int x, int y) {
        for (int i = 0; i < 4; ++i) {
            int count = 0;
            int ax = x + dx[i], ay = y + dy[i];
            while (inRange(ax, ay) && maze[ax][ay] == 0) {
                ++count;
                ax += dx[i];
                ay += dy[i];
            }
            ax -= dx[i];
            ay -= dy[i];
            if (costs[x][y] + count < costs[ax][ay]) {
                costs[ax][ay] = costs[x][y] + count;
                dfs(maze, ax, ay);
            }
        }
    }

    private boolean inRange(int x, int y) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }
}
