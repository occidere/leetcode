#include <stdio.h>
#define MAX(a, b) (a < b ? b : a)

int getMaximumGenerated(int n) {
	int max = n != 0;
	int arr[101] = {0, 1};
	for (int i = 2; i <= n; ++i) {
		arr[i] = arr[i >> 1] + (i % 2 == 0 ? 0 : arr[(i >> 1) + 1]);
		max = MAX(max, arr[i]);
	}
	
	return max;
}
