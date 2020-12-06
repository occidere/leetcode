class MovingAverage(private val size: Int) {
    private val data = arrayListOf<Int>()

    fun next(`val`: Int): Double {
        data += `val`
        if (data.size > size) {
            data.removeAt(0)
        }
        return data.average()
    }
}