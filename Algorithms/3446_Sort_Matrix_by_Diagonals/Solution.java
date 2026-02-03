class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int k = n - 1; k > 0; --k) {
            sort(grid, 0, k, false);
        }
        for (int k = 0; k < n; ++k) {
            sort(grid, k, 0, true);
        }
        return grid;
    }

    private void sort(int[][] grid, int x, int y, boolean desc) {
        int n = grid.length;
        List<Integer> l = new ArrayList<>();
        int i = x;
        int j = y;
        while (0 <= i && i < n && 0 <= j && j < n) {
            l.add(grid[i][j]);
            ++i;
            ++j;
        }
        if (desc) {
            Collections.sort(l, Collections.reverseOrder());
        } else {
            Collections.sort(l);
        }
        i = x;
        j = y;
        while (0 <= i && i < n && 0 <= j && j < n) {
            grid[i][j] = l.remove(0);
            ++i;
            ++j;
        }
    }
}
