#include <cstdio>
#include <vector>
#include <string>
using namespace std;

class Solution {
    public:
        vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
            vector<string> ans;
            string normalized_pattern = normalize(pattern);

            for (vector<int>::size_type i = 0; i < words.size(); i++) {
                string normalized_word = normalize(words[i]);
                if (normalized_pattern == normalized_word) {
                    ans.push_back(words[i]);
                }
            }

            return ans;
        }

    private:    
        string normalize(string word) {
            int num = 0, len = word.length();
            char cache[26] = {0, };
            string normalized = "";

            for (int i = 0; i < len; i++) {
                if (cache[word[i] - 97] != 0) {
                    normalized += cache[word[i] - 97];
                } else {
                    cache[word[i] - 97] = num + 48;
                    normalized += num + 48;
                    num++;
                }

            }

            return normalized;
        }
};
