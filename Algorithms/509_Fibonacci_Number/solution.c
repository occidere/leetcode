#include <stdio.h>

int fib(int N){
    int a = 0, b = 1, c;
    for (int i = 0; i < N; i++) {
        c = a;
        a = b;
        b = a + c;
    }
    return a;
}
