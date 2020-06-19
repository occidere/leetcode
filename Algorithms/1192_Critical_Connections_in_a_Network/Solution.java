import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    private int n;
    private int[] rank;
    private List<Integer>[] graph;
    private Set<List<Integer>> connectionSet;

    private static List<Integer> toSortedList(int a, int b) {
        return Arrays.asList(Math.min(a, b), Math.max(b, a));
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.n = n;
        rank = new int[n];
        graph = IntStream.range(0, n)
                .mapToObj(ArrayList<Integer>::new)
                .toArray(List[]::new);
        this.connectionSet = connections.stream()
                .peek(Collections::sort)
                .collect(Collectors.toSet());

        for (List<Integer> c : connections) {
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }

        Arrays.fill(rank, -2);

        dfs(0, 0);
        return new ArrayList<>(connectionSet);
    }

    private int dfs(int cur, int depth) {
        if (rank[cur] >= 0) {
            return rank[cur];
        }

        rank[cur] = depth;
        int minBacktrackedDepth = n;

        for (int next : graph[cur]) {
            if (rank[next] == depth - 1) {
                continue;
            }

            int backTrackedDepth = dfs(next, depth + 1);
            if (backTrackedDepth <= depth) {
                connectionSet.remove(Arrays.asList(Math.min(cur, next), Math.max(cur, next)));
            }
            minBacktrackedDepth = Math.min(minBacktrackedDepth, backTrackedDepth);
        }

        return minBacktrackedDepth;
    }
}