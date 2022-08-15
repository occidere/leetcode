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
        run(printFizz, "fizz");
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        run(printBuzz, "buzz");
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        run(printFizzBuzz, "fizzbuzz");
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        run(printNumber, "number");
    }

    private synchronized void run(Object obj, String type) throws InterruptedException {
        while (ai.get() <= n) {
            if (type.equals(getResponsibleThreadName())) {
                if (obj instanceof Runnable) {
                    ((Runnable) obj).run();
                    ai.getAndIncrement();
                } else if (obj instanceof IntConsumer) {
                    ((IntConsumer) obj).accept(ai.getAndIncrement());
                }
                notifyAll();
            } else {
                wait();
            }
        }
    }

    private String getResponsibleThreadName() {
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
