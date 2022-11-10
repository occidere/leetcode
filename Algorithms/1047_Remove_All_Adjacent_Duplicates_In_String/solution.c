#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* removeDuplicates(char* S){
    int k = 0, n = strlen(S);
    char* stk = malloc(200001);

    for (int i = 0; i < n; i++) {
        if (k > 0 && S[i] == stk[k - 1]) {
            k--;
        } else {
            stk[k++] = S[i];
        }
    }
    stk[k] = NULL;
    
    return stk;
}
