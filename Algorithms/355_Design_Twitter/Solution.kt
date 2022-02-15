class Twitter {

    private var timestamp = 0
    private val relations = mutableMapOf<Int, MutableSet<Int>>()
    private val tweetsByUser = mutableMapOf<Int, MutableList<Tweet>>()

    fun postTweet(userId: Int, tweetId: Int) {
        tweetsByUser.putIfAbsent(userId, mutableListOf())
        tweetsByUser[userId]!!
            .apply { add(Tweet(userId, tweetId, timestamp++)) }
            .apply { if (size > 10) removeAt(0) }
    }

    fun getNewsFeed(userId: Int): List<Int> {
        relations.putIfAbsent(userId, mutableSetOf(userId))
        return relations[userId]!!.flatMap { tweetsByUser.getOrDefault(it, mutableListOf()) }
            .sortedWith(Comparator { t1, t2 -> t2.timestamp - t1.timestamp })
            .map { it.tweetId }
            .take(10)
    }

    fun follow(followerId: Int, followeeId: Int) {
        relations.putIfAbsent(followerId, mutableSetOf(followerId))
        relations[followerId]!!.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        relations.putIfAbsent(followerId, mutableSetOf(followerId))
        relations[followerId]!!.remove(followeeId)
    }

    private data class Tweet(
        val userId: Int,
        val tweetId: Int,
        val timestamp: Int
    )
}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */
