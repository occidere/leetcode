import java.util.*;

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        return topologicalSort(n, relations);
    }

    /*
    Approach: 진입차수를 이용한 위상정렬 응용. indegree가 0인 애들과 연결된 노드 계산 후, 다음 타겟을 임시 리스트에 모아둔 뒤, 바꿔치기 하는 것이 응용 포인트

    Time Complexity: O(E + V). E = Number of edges, V = Number of vertice
    Space Complexity: O(E + V)
    */
    private int topologicalSort(int n, int[][] relations) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        for (int[] r : relations) {
            ++indegree[r[1]];
            graph[r[0]].add(r[1]);
        }

        int numberOfSteps = 0, totalCourses = 0;
        List<Integer> searchQ = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 0) {
                searchQ.add(i);
            }
        }

        while (!searchQ.isEmpty()) {
            ++numberOfSteps;
            List<Integer> nextQ = new LinkedList<>();
            for (int cur : searchQ) {
                ++totalCourses;
                for (int next : graph[cur]) {
                    if (--indegree[next] == 0) {
                        nextQ.add(next);
                    }
                }
            }
            searchQ = nextQ;
        }
        return totalCourses == n ? numberOfSteps : -1;
    }
}
