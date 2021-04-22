class Solution {

    /*
    Approach: 양쪽 끝 값을 비교해서 delta 를 찾은 뒤, 앞에서부터 순서대로 기대값과 실제값이 같은지 비교

    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public int missingNumber(int[] arr) {
        int d1 = arr[1] - arr[0], d2 = arr[arr.length - 1] - arr[arr.length - 2];
        int delta = d1 < 0 || d2 < 0 ? Math.max(d1, d2) : Math.min(d1, d2);

        int expected = arr[0];
        for (int i = 0; i < arr.length; i++, expected += delta) {
            if (arr[i] != expected) {
                return expected;
            }
        }

        return expected;
    }
}
