import java.util.HashMap;
import java.util.Map;

/**
 * @author occidere
 * @since 2019-12-09
 */
class LRUCache {
    private final Map<Integer, Node> cache = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        int val = -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            val = node.val;
            delete(node);
            insert(node);
        }
        return val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            delete(cache.get(key));
        } else if (cache.size() >= capacity) {
            delete(tail.next);
        }

        Node node = new Node(key, value);
        insert(node);
    }

    public void insert(Node node) {
        head.prev.next = node;
        node.prev = head.prev;

        head.prev = node;
        node.next = head;

        cache.put(node.key, node);
    }

    public void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        cache.remove(node.key);
    }

    private static final class Node {
        Node prev, next;
        int key, val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
