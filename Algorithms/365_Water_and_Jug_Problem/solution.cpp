#include <cstdio>

using namespace std;

class Solution {
public:
    
    // 3번째 항아리에 큰 항아리 만큼씩 물을 채우거나 작은 항아리만큼 물을 퍼내면서 target 맞추기
    // Ref: https://me2.do/5y0GRBd4
    bool canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        } else if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity) {
            return true;
        }

        if (jug1Capacity > jug2Capacity) {
            jug2Capacity += jug1Capacity;
            jug1Capacity = jug2Capacity - jug1Capacity;
            jug2Capacity -= jug1Capacity;
        }

        int jug3Capacity = 0;
        while (true) {
            // Pour jug2Capacity into jug3Capacity OR Scoop jug1Capacity from jug3Capacity
            if (jug3Capacity < jug1Capacity) {
                jug3Capacity += jug2Capacity;
            } else {
                jug3Capacity -= jug1Capacity;
            }

            if (jug3Capacity == targetCapacity) {
                return true;
            } else if (jug3Capacity == 0) {
                return false; // back to initial state -> will be repeated & can't get target
            }
        }
        return false;
    }
    
    // TLE
//     bool canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
//         if (jug1Capacity + jug2Capacity < targetCapacity) {
//             return false;
//         } else if (jug1Capacity + jug2Capacity == targetCapacity) {
//             return true;
//         }

//         set<pair<int, int>> visited;
//         queue<pair<int, int>> q;
//         q.push(make_pair(0, 0));
//         while (!q.empty()) {
//             pair<int, int> cur = q.front();
//             q.pop();
//             int a = cur.first, b = cur.second;

//             if (a == targetCapacity || b == targetCapacity || a + b == targetCapacity) {
//                 return true;
//             }

//             if (visited.find(cur) == visited.end()) {
//                 visited.insert(cur);
//                 q.push(make_pair(jug1Capacity, b));
//                 q.push(make_pair(a, jug2Capacity));
//                 q.push(make_pair(0, b));
//                 q.push(make_pair(a, 0));
//                 q.push(make_pair(min(jug1Capacity, a + b), b < jug1Capacity - a ? 0 : b - (jug1Capacity - a)));
//                 q.push(make_pair(a + b < jug2Capacity ? 0 : a - (jug2Capacity - b), min(a + b, jug2Capacity)));
//             }
//         }
        
//         return false;
//     }
};
