import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author occidere
 * @since 2019-12-06
 */
public class FreqStack {

    private int pos = 0;
    private final Map<Integer, Integer> freqCache = new HashMap<>();
    private final PriorityQueue<Metadata> pq = new PriorityQueue<>();

    public void push(int x) {
        freqCache.put(x, freqCache.getOrDefault(x, 0) + 1);
        pq.add(new Metadata(x, pos++, freqCache.get(x)));
    }

    public int pop() {
        freqCache.merge(pq.peek().getVal(), -1, Integer::sum);
        return pq.poll().getVal();
    }
}

final class Metadata implements Comparable<Metadata> {

    private int val;
    private int pos;
    private int freq;

    public Metadata(int val, int pos, int freq) {
        this.val = val;
        this.pos = pos;
        this.freq = freq;
    }

    public int getVal() {
        return val;
    }

    @Override
    public int compareTo(Metadata o) {
        if (freq == o.freq) {
            return Integer.compare(o.pos, pos);
        } else {
            return Integer.compare(o.freq, freq);
        }
    }
}
