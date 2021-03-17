import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<Integer> list = new ArrayList<>();
        list.add(lower - 1);
        for (int num : nums) {
            list.add(num);
        }
        list.add(upper + 1);

        return IntStream.range(1, list.size())
                .mapToObj(i -> {
                    int prev = list.get(i - 1) + 1, next = list.get(i) - 1;
                    if (prev == next) {
                        return prev + "";
                    } else if (prev < next) {
                        return prev + "->" + next;
                    } else {
                        return "";
                    }
                }).filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
    }
}