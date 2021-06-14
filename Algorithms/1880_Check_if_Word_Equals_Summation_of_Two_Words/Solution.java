class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toInt(firstWord) + toInt(secondWord) == toInt(targetWord);
    }

    private int toInt(String s) {
        return Integer.parseInt(s.chars().mapToObj(c -> (c - 'a') + "").collect(Collectors.joining()));
    }
}
