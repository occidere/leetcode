import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return Math.max(0, IntStream.range(0, satisfaction.length)
                    .map(i -> IntStream.range(i, satisfaction.length)
                        .map(j -> (j - i + 1) * satisfaction[j])
                        .sum()
                    ).max()
                    .getAsInt());
    }
}
