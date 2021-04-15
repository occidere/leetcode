class Solution {

    /*
    Approach: Sliding window 방법 사용. 최대 연속되야하는 1의 개수를 찾은 뒤, 그 사이즈만큼 윈도우를 잡아서 배열 처음부터 끝까지 비교하면서 윈도우 내 0의 개수 최소값을 찾음

    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public int minSwaps(int[] data) {
        int windowSize = 0;
        for (int d : data) {
            windowSize += d;
        }

        int numberOfZeroes = 0, numberOfOnes = 0, head = 0;
        for (; head < windowSize; ++head) {
            if (data[head] == 0) {
                ++numberOfZeroes;
            } else {
                ++numberOfOnes;
            }
        }

        int minZeroes = numberOfZeroes;
        for (head = windowSize; head < data.length; ++head) {
            if (data[head - windowSize] == 0) {
                --numberOfZeroes;
            } else {
                --numberOfOnes;
            }
            if (data[head] == 0) {
                ++numberOfZeroes;
            } else {
                ++numberOfOnes;
            }
            minZeroes = Math.min(minZeroes, numberOfZeroes);
        }

        return minZeroes;
    }
}
