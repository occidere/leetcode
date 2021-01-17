#include <stdio.h>

int countVowelStrings(int n){
    int vowels[6] = {1, 1, 1, 1, 1};
    
    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j < 5; ++j) {
            vowels[j] += vowels[j - 1];
        }
    }
    
    int sum = 0;
    for (int i = 0; i < 5; ++i) {
        sum += vowels[i];
    }
    
    return sum;
}
