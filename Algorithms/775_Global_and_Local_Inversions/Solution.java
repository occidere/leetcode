class Solution {

    /*
    Approach: local inversion 은 global inversion이기도 함. 따라서 local 이 아니면서 global 이 등장하면 false

    Time Complexity: O(N^2)
    Space Complexity: O(1)
    */
    // public boolean isIdealPermutation(int[] A) {
    //     for (int i = 0; i < A.length; ++i) {
    //         for (int j = i + 2; j < A.length; ++j) {
    //             if (A[i] > A[j]) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    /*
    Approach: 마지막 원소부터 2번째 원소까지 순회할 때 알고싶은건 결국, 현재 위치보다 2개 앞선 위치값들 중 현재 탐색한 값 까지의 최소값 보다 큰게 있는지 여부임
    ex) ..., 4, 2, (3), 1 일 때 현재가 3이고, 여기까지의 최소값은 1임. 이 때 현재보다 2개 앞선 위치인 4가 1보다 크기 때문에 global 이지만 local 이 아닌게 등장
    따라서 최소값을 갱신하면서, 현재 위치 i보다 2칸 앞선 i - 2 와 비교해서 A[i - 2] > minVal 인 케이스를 찾음

    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    // public boolean isIdealPermutation(int[] A) {
    //     int minVal = A.length;
    //     for (int i = A.length - 1; i >= 2; --i) {
    //         minVal = Math.min(minVal, A[i]);
    //         if (A[i - 2] > minVal) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /*
    Approach: 가장 이상적인 수열은 0, 1, 2, 3, 4 와 같이 오름차순 수열임
    이 때 global inversion == local inversion 을 유지하면서 각 원소가 이동할 수 있는 최대 위치는 최대 1칸임. 즉, 앞 뒤 원소끼리 서로 교체하는 느낌
    이 경우 기존 위치 i 와 실제 값 A[i] 의 차이는 항상 1보다 같거나 작게 유지됨

    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            if (Math.abs(A[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
