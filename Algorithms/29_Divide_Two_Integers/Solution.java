import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
1. Exponential Searches 적용: divisor 을 dividend 초과하는 범위까지 x2씩 하며 계산 & dividend 차감 후 반복 계산
2. Adding poser of two 적용: exponential search 방식에서 반복되는 재연산 제거
 */
class Solution {
    public int divide(int dividend, int divisor) {
        final int INT_MIN_HALF = -1073741824; // -2^30

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // overflow 방지 (INT_MIN 이 INT_MAX 보다 1 만큼 더 넓은 범위기 때문)
        }

        // 음수값 범위가 양수값 범위보다 1 넓기 때문에 더 넓은 범위를 쓰기 위해 음수로 만들고 시작
        int negatives = 2;
        if (dividend > 0) {
            --negatives;
            dividend = -dividend;
        }
        if (divisor > 0) {
            --negatives;
            divisor = -divisor;
        }

        // Pair = (2의제곱수, divisor 의 2배수)
        List<Point> list = new ArrayList<>();
        int powerOfTwo = -1;
        while (dividend <= divisor) { // 음수로 치환했으므로 대소비교도 반대로 변환
            list.add(new Point(powerOfTwo, divisor));
            if (divisor < INT_MIN_HALF) {
                break; // overflow 방지
            }
            divisor <<= 1;
            powerOfTwo <<= 1;
        }

        // 큰 값 -> 작은 값 순 탐색
        int quotient = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            Point p = list.get(i);
            if (p.y >= dividend) {
                quotient += p.x;
                dividend -= p.y;
            }
        }

        return negatives != 1 ? -quotient : quotient;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(10, 3));
        System.out.println(new Solution().divide(7, -3));
        System.out.println(new Solution().divide(0, 1));
        System.out.println(new Solution().divide(1, 1));
    }
}