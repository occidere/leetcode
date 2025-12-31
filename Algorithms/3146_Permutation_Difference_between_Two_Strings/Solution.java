class Solution {
    public int findPermutationDifference(String s, String t) {
        return IntStream.range(0, s.length())
            .map(i -> Math.abs(i - t.indexOf(s.charAt(i))))
            .sum();
    }
}
