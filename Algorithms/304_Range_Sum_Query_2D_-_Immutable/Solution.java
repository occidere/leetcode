import java.util.*;

class NumMatrix {
    private int[][] d;
    private int m, n;

    /*
    Approach: column 합을 저장한 뒤 사용

    Time Complexity: O(M*N)
    Space Complexity: O(M*N)
    */
    public NumMatrix(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        d = new int[m][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d[i][j + 1] = d[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; ++i) {
            sum += d[i][col2 + 1] - d[i][col1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
