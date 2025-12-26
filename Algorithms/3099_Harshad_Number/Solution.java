class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int h = String.valueOf(x)
            .chars()
            .map(c -> c - 48)
            .sum();
        return x % h == 0 ? h : -1;
    }
}
