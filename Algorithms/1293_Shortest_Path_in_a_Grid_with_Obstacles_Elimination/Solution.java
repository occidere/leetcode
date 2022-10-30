/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-30
 */
class Solution {
	public int shortestPath(int[][] grid, int k) {
		final int[] dx = new int[]{-1, 1, 0, 0}, dy = new int[]{0, 0, -1, 1};
		final int m = grid.length, n = grid[0].length;
		var visit = new boolean[m][n][k + 1];
		var q = new java.util.LinkedList<Grid>();
		q.add(new Grid(0, 0, k, 0));

		while (!q.isEmpty()) {
			var cur = q.removeFirst();
			visit[cur.x][cur.y][cur.e] = true;
			if (cur.x == m - 1 && cur.y == n - 1) {
				return cur.d;
			}

			for (var i = 0; i < 4; ++i) {
				var ax = cur.x + dx[i];
				var ay = cur.y + dy[i];
				if (0 <= ax && ax < m && 0 <= ay && ay < n) {
					if (grid[ax][ay] == 1) {
						if (0 < cur.e && !visit[ax][ay][cur.e - 1]) {
							visit[ax][ay][cur.e - 1] = true;
							q.add(new Grid(ax, ay, cur.e - 1, cur.d + 1));
						}
					} else if (!visit[ax][ay][cur.e]) {
						visit[ax][ay][cur.e] = true;
						q.add(new Grid(ax, ay, cur.e, cur.d + 1));
					}
				}
			}
		}

		return -1;
	}

	private record Grid(int x, int y, int e, int d) {

	}
}
