#include <stdio.h>
#include <string.h>

int min(int a, int b) {
    return a < b ? a : b;
}

int is_balloon(char c) {
    return c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n';
}

int maxNumberOfBalloons(char* text) {
    int freq[8] = {0}, n = strlen(text);
    for (int i = 0; i < n; i++) {
        if (is_balloon(text[i])) {
            freq[text[i] % 8]++;
        }
    }
    return min(freq[1], min(freq[2], min(freq[6], min(freq[4] / 2, freq[7] / 2))));
}
