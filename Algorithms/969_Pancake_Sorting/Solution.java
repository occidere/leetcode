import java.util.*;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        for (int i = sorted.length - 1; i >= 0 && !isSorted(arr); --i) {
            int idx = indexOf(arr, sorted[i]);
            flip(arr, idx);
            ans.add(idx + 1);
            flip(arr, i);
            ans.add(i + 1);
        }
        return ans;
    }

    private int indexOf(int[] arr, int x) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    private void flip(int[] arr, int to)  {
        for (int from = 0; from <= to; ++from, --to) {
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }
    }

    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
