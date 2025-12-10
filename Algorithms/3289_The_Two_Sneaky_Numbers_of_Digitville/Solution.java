public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() > 1)
            .mapToInt(e -> e.getKey())
            .toArray();
    }
}
