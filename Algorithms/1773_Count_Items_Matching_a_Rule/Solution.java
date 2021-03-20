import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        return (int) items.stream().filter(xs -> {
            switch (ruleKey) {
                case "type":
                    return ruleValue.equals(xs.get(0));
                case "color":
                    return ruleValue.equals(xs.get(1));
                default:
                    return ruleValue.equals(xs.get(2));
            }
        }).count();
    }
}