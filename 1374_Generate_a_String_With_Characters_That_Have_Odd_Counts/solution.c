#include <stdio.h>
#include <stdlib.h>

char * generateTheString(int n){
    char* s = malloc(n * 500);
    if (n % 2 == 0) {
        s[0] = 'a';
    }
    for (int i = (n % 2 == 0); i < n; s[i++] = 'b');
    s[n] = NULL;
    return s;
}
