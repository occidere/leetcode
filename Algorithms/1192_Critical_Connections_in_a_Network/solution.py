import collections


class Solution(object):
    def criticalConnections(self, n, connections):
        rank = [-2] * n
        graph = collections.defaultdict(list)
        for conn in connections:
            graph[conn[0]].append(conn[1])
            graph[conn[1]].append(conn[0])
        connections = set(map(tuple, (map(sorted, connections))))

        def dfs(cur, depth):
            if rank[cur] >= 0:
                return rank[cur]

            rank[cur] = depth
            min_back_depth = n

            for nex in graph[cur]:
                if rank[nex] == depth - 1:
                    continue

                back_depth = dfs(nex, depth + 1)
                if back_depth <= depth:
                    connections.discard(tuple(sorted((cur, nex))))
                min_back_depth = min(min_back_depth, back_depth)

            return min_back_depth

        dfs(0, 0)
        return list(connections)
