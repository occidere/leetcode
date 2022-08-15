import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-15
 */
public class FizzBuzz {
    private final int n;
    private final AtomicInteger ai;

    public FizzBuzz(int n) {
        this.n = n;
        this.ai = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (ai.get() <= n) {
                if ("fizz".equals(getResponsibleThreadName())) {
                    printFizz.run();
                    ai.getAndIncrement();
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (ai.get() <= n) {
                if ("buzz".equals(getResponsibleThreadName())) {
                    printBuzz.run();
                    ai.getAndIncrement();
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (ai.get() <= n) {
                if ("fizzbuzz".equals(getResponsibleThreadName())) {
                    printFizzBuzz.run();
                    ai.getAndIncrement();
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (ai.get() <= n) {
                if ("number".equals(getResponsibleThreadName())) {
                    printNumber.accept(ai.getAndIncrement());
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    private synchronized String getResponsibleThreadName() {
        final boolean forFizz = ai.get() % 3 == 0, forBuzz = ai.get() % 5 == 0;
        if (forFizz && forBuzz) {
            return "fizzbuzz";
        } else if (forFizz) {
            return "fizz";
        } else if (forBuzz) {
            return "buzz";
        } else {
            return "number";
        }
    }
}
