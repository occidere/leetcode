/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    private Map<Integer, Integer> elements = new HashMap<>();
    private int maxDepth = 1;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        int sum = 0;
        for (Map.Entry<Integer, Integer> e : elements.entrySet()) {
            sum += (maxDepth - e.getKey() + 1) * e.getValue();
        }
        return sum;
    }

    private void dfs(List<NestedInteger> nestedList, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                elements.merge(depth, ni.getInteger(), Integer::sum);
            } else {
                dfs(ni.getList(), depth + 1);
            }
        }
    }
}
