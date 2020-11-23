/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-11-23
 */
class MyCircularQueue {

    private final int[] q;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public MyCircularQueue(int k) {
        q = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        q[rear] = value;
        rear = incr(rear);
        ++size;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = incr(front);
        --size;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[decr(rear)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == q.length;
    }

    private int incr(int num) {
        return (num + 1) % q.length;
    }

    private int decr(int num) {
        return (num + q.length - 1) % q.length;
    }
}
