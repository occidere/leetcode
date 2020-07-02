import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final int[] DX = {-1, 1, 0, 0}, DY = {0, 0, -1, 1};
    private static final String[] DIRECTION = {"U", "D", "L", "R"};
    private int[][] grid;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder island = new StringBuilder();
                    dfs(i, j, island);
                    islands.add(island.toString().trim());
                }
            }
        }

        return islands.size();
    }

    private void dfs(int x, int y, StringBuilder island) {
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int ax = x + DX[i], ay = y + DY[i];
            if (inRange(ax, ay) && grid[ax][ay] == 1) {
                island.append(DIRECTION[i]);
                dfs(ax, ay, island);
                island.append(" ");
            }
        }
    }

    private boolean inRange(int x, int y) {
        return (0 <= x && x < grid.length) && (0 <= y && y < grid[0].length);
    }
}