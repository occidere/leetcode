/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-06-16
 */
class AuthenticationManager(private val timeToLive: Int) {

    private val tokenMap = mutableMapOf<String, Int>()

    fun generate(tokenId: String, currentTime: Int) {
        evictExpired(currentTime)
        tokenMap[tokenId] = currentTime + timeToLive
    }

    fun renew(tokenId: String, currentTime: Int) {
        evictExpired(currentTime)
        if (tokenMap.contains(tokenId)) {
            generate(tokenId, currentTime)
        }
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        evictExpired(currentTime)
        return tokenMap.size
    }

    private fun evictExpired(currentTime: Int) {
        tokenMap.filter { it.value <= currentTime }
            .map { it.key }
            .forEach { tokenMap.remove(it) }
    }

}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * var obj = AuthenticationManager(timeToLive)
 * obj.generate(tokenId,currentTime)
 * obj.renew(tokenId,currentTime)
 * var param_3 = obj.countUnexpiredTokens(currentTime)
 */
