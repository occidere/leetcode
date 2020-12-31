#include <stdio.h>

bool validateStackSequences(int* pushed, int pushedSize, int* popped, int poppedSize) {
    int size = 0;
    if (pushedSize > 0) {
        int i = 0;
        int stk[pushedSize];
        for (int k = 0; k < pushedSize; k++) {
            stk[size++] = pushed[k];

            while (size > 0 && stk[size - 1] == popped[i]) {
                --size;
                ++i;
            }
        }
    }
    return size == 0;
}
