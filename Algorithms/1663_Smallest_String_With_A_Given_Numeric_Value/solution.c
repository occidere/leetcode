#include <stdio.h>
#include <stdlib.h>

char * getSmallestString(int n, int k) {
    char *seq = malloc(sizeof(char) * (n + 1));
    for (int i = 0; i < n; seq[i++] = 'a');
    seq[n] = '\0';

    int diff = k - n;
    for (; diff >= 25; diff -= 25) {
        seq[--n] += 25;
    }
    if (n > 0) {
        seq[--n] += diff;
    }

    return seq;
}
