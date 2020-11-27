import kotlin.math.max
import kotlin.math.min

/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-11-27
 */
class BrowserHistory(homepage: String) {
    private val histories = Array(5000) { "" }
    private var cur = -1
    private var end = -1

    init {
        visit(homepage)
    }

    fun visit(url: String) {
        histories[++cur] = url
        end = cur
    }

    fun back(steps: Int): String = max(0, cur - steps).let {
        cur = it
        histories[it]
    }

    fun forward(steps: Int): String = min(end, cur + steps).let {
        cur = it
        histories[it]
    }
}