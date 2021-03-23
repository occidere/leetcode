import java.util.*;

class Solution {
    public int[] findBuildings(int[] heights) {
        return rightToLeft(heights);
        // return leftToRight(heights);
    }

    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    private int[] rightToLeft(int[] heights) {
        int n = heights.length, h = heights[n - 1];
        List<Integer> oceanViews = new LinkedList<>();
        oceanViews.add(n - 1);
        for (int i = n - 2; i >= 0; --i) {
            if (heights[i] > h) {
                h = heights[i];
                oceanViews.add(0, i);
            }
        }
        return oceanViews.stream().mapToInt(x -> x).toArray();
    }

    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    private int[] leftToRight(int[] heights) {
        Stack<Integer> oceanViews = new Stack<>();
        for (int i = 0; i < heights.length; ++i) {
            while (!oceanViews.isEmpty() && heights[oceanViews.peek()] <= heights[i]) {
                oceanViews.pop();
            }
            oceanViews.push(i);
        }
        return oceanViews.stream().mapToInt(x -> x).toArray();
    }
}
