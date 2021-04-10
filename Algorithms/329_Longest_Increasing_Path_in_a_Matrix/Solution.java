import java.util.*;

class Solution {
    private int rows, cols;
    private int[][] costs, mat;
    private final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    /*
    Approach: Move small to big during memorize max length of current position.
    */
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        mat = matrix;
        costs = new int[rows][cols];

        int maxLen = 1;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (costs[i][j] == 0) {
                    maxLen = Math.max(maxLen, dfs(i, j));
                }
            }
        }
        return maxLen;
    }

    /*
    Approach: costs[x][y] = (x, y) 에 도착했을 때 최대거리. 일단 갈 수 있는데 까지 쭉 가고, 마지막에 ++ 로 값을 1 올려줌

    Time Complexity: O(MN). V = 노드 개수, E = 간선 개수일 때 O(V) = O(MN) 이고, O(E) = O(4V) = O(Mn).
    Space Complexity: O(MN)
    */
    private int dfs(int x, int y) {
        if (costs[x][y] != 0) {
            return costs[x][y];
        }

        for (int i = 0; i < 4; ++i) {
            int ax = x + dx[i], ay = y + dy[i];
            if (inRange(ax, ay) && mat[x][y] < mat[ax][ay]) {
                costs[x][y] = Math.max(costs[x][y], dfs(ax, ay));
            }
        }
        return ++costs[x][y];
    }

    /*
    Approach: 초기버전. 전부 탐색하면서 최대길이 메모 갱신 & 더 긴 거리가 가능할 경우 재탐색

    Time Complexity: O(M^2 * N^2)
    Space Complexity: O(MN)
    */
    // private int dfs(int x, int y) {
    //     int maxLen = costs[x][y];
    //     for (int i = 0; i < 4; ++i) {
    //         int ax = x + dx[i], ay = y + dy[i];
    //         if (inRange(ax, ay) && mat[x][y] < mat[ax][ay] && costs[x][y] + 1 > costs[ax][ay]) {
    //             costs[ax][ay] = costs[x][y] + 1;
    //             maxLen = Math.max(maxLen, dfs(ax, ay));
    //         }
    //     }
    //     return maxLen;
    // }

    private boolean inRange(int x, int y) {
        return (0 <= x && x < rows) && (0 <= y && y < cols);
    }
}
