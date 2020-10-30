import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        final BiFunction<int[], int[], Stream<Point>> zip = (a, b) -> IntStream.range(0, Math.min(a.length, b.length))
                .mapToObj(i -> new Point(a[i], b[i]));
        return zip.apply(l, r)
                .map(xs -> Arrays.copyOfRange(nums, xs.x, xs.y + 1))
                .peek(Arrays::sort)
                .map(xs -> zip.apply(xs, Arrays.copyOfRange(xs, 1, xs.length)).map(ys -> ys.x - ys.y).distinct().count() == 1)
                .collect(Collectors.toList());
    }
}