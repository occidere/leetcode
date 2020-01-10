#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MIN(a, b) a < b ? a : b

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** commonChars(char** A, int ASize, int* returnSize){
    int p = 0;
    int freq[100][26] = {0};
    char** common = malloc(sizeof(char *) * 100);

    for (int i = 0; i < ASize; i++) {
        for (int j = 0; j < strlen(A[i]); j++) {
            freq[i][A[i][j] - 97]++;
        }
    }

    for (int i = 0; i < 100; i++) {
        common[i] = calloc(1, sizeof(char *));
    }

    for (int i = 0; i < 26; i++) {
        int k = freq[0][i], min = k;
        for (int j = 1; j < ASize; min = MIN(min, freq[j][i]), j++);
        for (int j = 0; j < min; common[p++][0] = (char) i + 97, j++);
    }

    *returnSize = p;

    return common;
}
