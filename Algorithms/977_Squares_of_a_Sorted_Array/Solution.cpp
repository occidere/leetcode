#include <cstdio>
#include <vector>
#include <cmath>
using namespace std;

class Solution
{
  public:
	vector < int >sortedSquares(vector < int >&A)
	{
		int n = A.size();
		int l = 0, r = n - 1;
		vector < int >res(n);

		for (int i = n - 1; i > -1; i--)
		{
			if (abs(A[l]) > abs(A[r]))
			{
				res[i] = A[l] * A[l];
				l++;
			}
			else
			{
				res[i] = A[r] * A[r];
				r--;
			}
		}

		return res;
	}
};
