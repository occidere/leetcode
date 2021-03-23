import java.util.*;

class Solution {
    /*
    [스스로 푼 버전]
    조합(nCr)을 이용해서 풀이
    Time complexity: O(N + W^2)
    Space Complexity: O(N)
    */
    private long[][] c = new long[3001][4];
    private static final long INF = 1000000007;

    public int threeSumMulti(int[] arr, int target) {
        int[] cnt = new int[101];
        for (int a : arr) {
            ++cnt[a];
        }

        long ans = 0;
        for (int i = 0; i <= 100; ++i) {
            for (int j = i; j <= 100; ++j) {
                int k = target - i - j;
                int iCnt = cnt[i], jCnt = cnt[j];
                int kCnt = 0 <= k && k <= 100 ? cnt[k] : 0;
                if (i <= j && j <= k) {
                    if (i == j && j == k && iCnt >= 3) {
                        ans += nCr(iCnt, 3) % INF;
                    } else if (i == j && j != k && iCnt >= 2) {
                        ans += (nCr(iCnt, 2) * nCr(kCnt, 1)) % INF;
                    } else if (i == k && j != k && iCnt >= 2) {
                        ans += (nCr(iCnt, 2) * nCr(jCnt, 1)) % INF;
                    } else if (j == k && i != k && jCnt >= 2) {
                        ans += (nCr(jCnt, 2) * nCr(iCnt, 1)) % INF;
                    } else if (i != j && j != k) {
                        ans += (((nCr(iCnt, 1) * nCr(jCnt, 1)) % INF) * nCr(kCnt, 1)) % INF;
                    }
                }
            }
        }
        return (int) ans;
    }

    private long nCr(int n, int r) {
        if (c[n][r] == 0) {
            c[n][r] = n;
            for (long i = n - 1; i > n - r && i > 0; --i) {
                c[n][r] *= i;
            }
            for (long i = 2; i <= r; ++i) {
                c[n][r] /= i;
            }
        }
        return c[n][r];
    }
}
