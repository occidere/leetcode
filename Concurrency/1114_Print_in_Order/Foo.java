import java.util.concurrent.Semaphore;

/**
 * @author occidere
 * @since 2019-07-13
 * Blog: https://blog.naver.com/occidere
 * Github: https://github.com/occidere
 */
class Foo {
    private Semaphore s2 = new Semaphore(0), s3 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        s3.release();
    }
}
