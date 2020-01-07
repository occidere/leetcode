#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            visit.push_back(0);
        }

        dfs(rooms, 0);

        for (int v : visit) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

private:
    vector<int> visit;

    void dfs(vector<vector<int>>& rooms, int cur) {
        visit[cur] = 1;
        for (int& next : rooms[cur]) {
            if (!visit[next]) {
                dfs(rooms, next);
            }
        }
    }
};
