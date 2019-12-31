#include <cstdio>
#include <string>
#include <map>
using namespace std;

class Solution {
public:
    string encode(string longUrl) {
        if (encoder.count(longUrl) == 0) {
            encoder.insert(map<string, int>::value_type(longUrl, n));
            decoder.insert(map<int, string>::value_type(n++, longUrl));
        }
        return "http://tinyurl.com/" + to_string(encoder[longUrl]);
    }

    string decode(string shortUrl) {
        return decoder[atoi(shortUrl.substr(shortUrl.find("http://tinyurl.com/"), shortUrl.length()).c_str())];
    }

private:
    int n = 0;
    map<string, int> encoder;
    map<int, string> decoder;
};
