#include <cstdio>
using namespace std;

class MyCircularQueue {
public:
    MyCircularQueue(int k) {
        _k = k;
        q = new int[k];
    }

    bool enQueue(int value) {
        if (isFull()) {
            return false;
        }
        q[rear] = value;
        rear = incr(rear);
        ++size;
        return true;
    }

    bool deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = incr(front);
        --size;
        return true;
    }

    int Front() {
        return isEmpty() ? -1 : q[front];
    }
    
    int Rear() {
        return isEmpty() ? -1 : q[decr(rear)];
    }

    bool isEmpty() {
        return size == 0;
    }

    bool isFull() {
        return size == _k;
    }

private:
    int* q;
    int _k;
    int front = 0;
    int rear = 0;
    int size = 0;
    
    int incr(int num) {
        return (num + 1) % _k;
    }
    
    int decr(int num) {
        return (num + _k - 1) % _k;
    }
};
