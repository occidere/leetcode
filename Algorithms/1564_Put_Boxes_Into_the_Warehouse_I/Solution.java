import java.util.*;

class Solution {

    /*
    Approach:
        - warehouse를 상한 높이에 맞춰 재조정: [3,4,1,2] -> [3,3,1,1]
        - boxes를 오름차순 정렬해서 작은놈부터 시도하도록 준비
        - warehouse 는 마지막부터, warehouse 는 처음부터 탐색하며 box <= warehouse 면 boxIdx++ 하면서 카운트

    Time Complexity: O(M + NlogN). M은 warehouse 길이, N은 box 길이
    Space Complexity: O(1)
    */
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        for (int i = 1; i < warehouse.length; ++i) {
            if (warehouse[i] > warehouse[i - 1]) {
                warehouse[i] = warehouse[i - 1];
            }
        }
        int boxCount = 0;
        for (int i = warehouse.length - 1; boxCount < boxes.length && i >= 0; --i) {
            if (boxes[boxCount] <= warehouse[i]) {
                ++boxCount;
            }
        }
        return boxCount;
    }
}
