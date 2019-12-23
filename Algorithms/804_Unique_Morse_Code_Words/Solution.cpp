#include <cstdio>
#include <set>
#include <vector>
#include <string>
using namespace std;

class Solution {
    public:
        int uniqueMorseRepresentations(vector<string>& words) {
            set<string> morses;

            for (string& str : words) {
                string s = "";
                for (char& c : str) {
                    s += morse[c - 97];
                }
                morses.insert(s);
            }

            return morses.size();
        }

    private:
        string morse[26] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
};
