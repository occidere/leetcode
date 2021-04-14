mport java.util.*;

class Solution {

    /*
    Approach: Kruskal 알고리즘을 사용해서 MST 를 구한다. 쉽게말해 최소비용으로 모든 노드를 연결하는 방법을 찾는다.
    Kruskal 알고리즘은 모든 간선을 최소 비용 순서로 정렬한 뒤, Union Find 로 각각의 노드를 최소비용으로 연결을 시도한다.
    모든 노드를 1개의 간선으로만 연결하기 때문에 N 개의 노드가 있으면 간선의 개수는 정확히 N - 1개가 나올 것이다.
    만약 주어진 모든 간선에 대해 연결을 시도했어도 N - 1 개 만큼의 연결이 나오지 않는다면, MST 를 만들 수 없다는 뜻이다.

    Time Complexity: O(ElogE). E는 간선의 개수, V는 노드 개수일 때 정렬하는데 O(ElogE), union find 에 O(Elog*V) 가 소요
    Space Complexity: O(V). V는 노드의 개수
    */
    public int minimumCost(int N, int[][] connections) {
        int[] parent = new int[N];
        for (int i = 0; i < connections.length; ++i) {
            --connections[i][0];
            --connections[i][1];
        }
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        Arrays.fill(parent, -1);

        int numberOfConnections = 0, totalCost = 0;
        for (int i = 0; i < connections.length && numberOfConnections < N - 1; ++i) {
            if (union(parent, connections[i][0], connections[i][1])) {
                ++numberOfConnections;
                totalCost += connections[i][2];
            }
        }

        return numberOfConnections == N - 1 ? totalCost : -1;
    }

    private boolean union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }

    private int find(int[] parent, int cur) {
        return parent[cur] == -1 ? cur : (parent[cur] = find(parent, parent[cur]));
    }
}
