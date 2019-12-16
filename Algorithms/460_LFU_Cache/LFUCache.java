import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author occidere
 * @since 2019-12-16
 */
class LFUCache {

    private int capacity;
    private int minFreq = -1; // 캐싱된 데이터들 중 가장 낮은 빈도 수
    private Map<Integer, Integer> keyToVal = new HashMap<>(); // {key : value} 매핑
    private Map<Integer, Integer> keyToFreq = new HashMap<>(); // {key : 접근빈도} 매핑
    // {접근빈도 : [key3, key2, key1 ...]} 매핑 (Set 의 앞쪽일수록 오래된 것, 뒷쪽일수록 신규)
    private Map<Integer, Set<Integer>> freqToLRUKeys = new HashMap<Integer, Set<Integer>>() {{
        put(1, new LinkedHashSet<>());
    }};

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 캐싱값이 없으면 -1
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int freq = keyToFreq.get(key); // 해당 key 의 빈도수 가져와서
        freqToLRUKeys.get(freq).remove(key); // 기존 빈도수 데이터 지우고
        putFreq(key, freq + 1); // 빈도수 + 1 로 갱신

        // 해당 key 의 빈도수가 가장 낮은 빈도수면서, 그 빈도수에 해당하는 key들이 더이상 없으면
        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            minFreq++; // 최소 빈도수 값 증가 (evict 시 제대로된 최소 빈도값의 데이터를 제거하기 위해)
        }

        return keyToVal.get(key); // 캐싱된 값 반환
    }

    public void put(int key, int value) {
        // 용량이 0 이하인 경우의 방어로직
        if (capacity <= 0) {
            return;
        }

        // 이미 캐싱된 값이 또 들어오는 경우
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value); // 새 값으로 덮어씌우고
            get(key); // 빈도수 갱신
            return;
        }

        /* 여기부턴 캐싱되지 않은 신규 데이터가 들어오는 경우 */

        // 용량 초과 시 첫번째 (가장 오래된) 데이터 evict
        if (keyToVal.size() >= capacity) {
            evict(freqToLRUKeys.get(minFreq).iterator().next());
        }

        minFreq = 1; // 신규 데이터이므로 최소 빈도수는 무조건 1
        putFreq(key, minFreq); // 새로 들어온 현재 key를 최소 빈도수로 갱신
        keyToVal.put(key, value); // key : value 매핑한 map에 추가
    }

    // 빈도수 갱신
    private void putFreq(int key, int freq) {
        keyToFreq.put(key, freq);
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToLRUKeys.get(freq).add(key);
    }

    // 가장 접근빈도가 낮은 데이터 evict
    private void evict(int key) {
        freqToLRUKeys.get(minFreq).remove(key); // 최소 접근빈도가 저장된 minFreq 에 해당하는 key 를 제거
        keyToVal.remove(key); // 값도 제거
    }
}