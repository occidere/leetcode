#include <stdio.h>

typedef unsigned long long ull;

bool isPerfectSquare(int num)
{
    ull left = 1, right = num, ans = 0;

    while (left <= right)
    {
        ull mid = (left + right) / 2, p = mid * mid;

        if (p < num)
        {
            left = mid + 1;
        }
        else if (p > num)
        {
            right = mid - 1;
        }
        else
        {
            ans = mid;
            break;
        }
    }

    return ans;
}
