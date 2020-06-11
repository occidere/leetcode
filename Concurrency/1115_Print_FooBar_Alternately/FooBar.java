/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-06-11
 */
class FooBar {

    private int n;
    private boolean timeForFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (!timeForFoo) {
                    wait();
                }
                printFoo.run();
                timeForFoo = false;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (timeForFoo) {
                    wait();
                }
                printBar.run();
                timeForFoo = true;
                notify();
            }
        }
    }
}
