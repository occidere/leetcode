import java.util.*;

class Solution {
    /*
    Approach 1: Flood from both pacific and atlantic & return intersections

    Time Complexity: O(M*N)
    Space Complexity: O(M*N)
    */
    private final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    private int m, n, mat[][];

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        this.mat = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;

        Set<String> pacific = floodFromPacific();
        Set<String> atlantic = floodFromAtlantic();
        pacific.retainAll(atlantic);

        return pacific.stream()
            .map(s -> s.split(" "))
            .map(xs -> Arrays.asList(new Integer(xs[0]), new Integer(xs[1])))
            .collect(Collectors.toList());
    }

    private Set<String> floodFromPacific() {
        Set<String> pacific = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            pacific.add(i + " " + 0);
        }
        for (int i = 0; i < n; ++i) {
            pacific.add(0 + " " + i);
        }

        bfs(pacific);

        return pacific;
    }

    private Set<String> floodFromAtlantic() {
        Set<String> atlantic = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            atlantic.add(i + " " + (n - 1));
        }
        for (int i = 0; i < n; ++i) {
            atlantic.add((m - 1) + " " + i);
        }

        bfs(atlantic);

        return atlantic;
    }

    private void bfs(Set<String> ocean) {
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (String o : ocean) {
            int[] pos = Arrays.stream(o.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            q.offer(pos);
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visit[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; ++i) {
                int ax = cur[0] + dx[i], ay = cur[1] + dy[i];
                if (inRange(ax, ay) && !visit[ax][ay] && mat[cur[0]][cur[1]] <= mat[ax][ay]) {
                    q.offer(new int[]{ax, ay});
                    ocean.add(ax + " " + ay);
                }
            }
        }
    }

    private boolean inRange(int x, int y) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }


    /*
    Approach 2: flood from every cell & check if reach both pacific and atlantic
    
    Time Complexity: O(M^2 * N^2)
    Space Complexity: O(M*N)
    */
//     private final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
//     private int[][] mat;
//     private int m, n;
    
//     public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//         List<List<Integer>> ans = new ArrayList<>();

//         if (matrix.length > 0) {
//             this.mat = matrix;
//             this.m = matrix.length;
//             this.n = matrix[0].length;

//             for (int i = 0; i < m; ++i) {
//                 for (int j = 0; j < n; ++j) {
//                     if (flood(i, j)) {
//                         ans.add(Arrays.asList(i, j));
//                     }
//                 }
//             }
//         }

//         return ans;
//     }

//     private boolean flood(int x, int y) {
//         boolean[][] visit = new boolean[m][n];
//         boolean reachPacific = false, reachAtlantic = false;
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{x, y});
//         visit[x][y] = true;

//         while (!q.isEmpty()) {
//             int[] cur = q.poll();
//             for (int i = 0; i < 4; ++i) {
//                 int ax = cur[0] + dx[i], ay = cur[1] + dy[i];
//                 if (inRange(ax, ay)) {
//                     if (!visit[ax][ay] && mat[cur[0]][cur[1]] >= mat[ax][ay]) {
//                         q.offer(new int[]{ax, ay});
//                         visit[ax][ay] = true;
//                     }
//                 } else {
//                     reachPacific |= ax == -1 || ay == -1;
//                     reachAtlantic |= ax == m || ay == n;
//                     if (reachPacific && reachAtlantic) {
//                         return true;
//                     }
//                 }
//             }
//         }

//         return false;
//     }

//     private boolean inRange(int x, int y) {
//         return (0 <= x && x < m) && (0 <= y && y < n);
//     }
}
