#include <cstdio>
#include <vector>
#include <string>
#include <set>
using namespace std;

class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        int idx[4] = {0, 0, 0, 0};
        dfs(s, idx, 0);
        vector<string> ans(ips.begin(), ips.end());
        return ans;
    }

private:
    set<string> ips;

    void dfs(string s, int idx[], int k) {
        if (k == 4) {
            if (idx[0] + idx[1] + idx[2] + idx[3] == s.size()) {
                int ip[4], acc = 0;
                for (int i = 0; i < 4; ++i) {
                    string sub = s.substr(acc, idx[i]);
                    ip[i] = stoi(sub);

                    if (ip[i] > 255 || (sub.size() > 1 && sub[0] == '0')) {
                        return;
                    }
                    acc += idx[i];
                }
                ips.insert(to_string(ip[0]) + "." + to_string(ip[1]) + "." + to_string(ip[2]) + "." + to_string(ip[3]));
            }
            return;
        }

        for (int i = 1; i < 4; ++i) {
            idx[k] = i;
            dfs(s, idx, k + 1);
        }
    }
};
