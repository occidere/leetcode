class Solution {
    public int gcdOfOddEvenSums(int n) {
        int a = 0, b = 0;
        for (int i = 1; i <= (n << 1); i += 2) {
            a += i;
            b += i + 1;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
