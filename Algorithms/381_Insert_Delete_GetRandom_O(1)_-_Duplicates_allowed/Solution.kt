import kotlin.random.Random

/**
 * Ref: https://me2.do/5WBvxnWD
 *
 * [INSERT 로직]
 * 1. map 에는 아래와 같이 저장
 *  - 키: val
 *  - 값: nums 내에서 val 의 인덱스들
 * 2. nums 에는 아래와 같이 저장
 *  - IntArray(val, map 내 list 에 추가될 때의 인덱스)
 * ex)
 * insert 1
 *  - map = {1: [0]}
 *  - nums = [[1, 0]]
 * insert 2
 *  - map: {1: [0], 2: [0]}
 *  - nums: [[1, 0], [2, 0]]
 * insert 1
 *  - map: {1: [0, 2], 2: [0]}
 *  - nums: [[1, 0], [2, 0], [1, 1]]
 * insert 2
 *  - map: {1: [0, 2], 2: [0, 3]}
 *  - nums: [[1, 0], [2, 0], [1, 1], [2, 1]]
 *
 *
 *  [DELETE 로직]
 *  1. map 에서 삭제 대상의 nums 에서의 마지막 인덱스 찾기
 *  2. 위에서 찾은 nums 에서 val 의 마지막 위치에, 실제로 nums 에 마지막으로 들어온 값을 overwrite
 *      - nums 에 실제로 마지막으로 들어온 놈이, vals 가 마지막으로 들어온 위치에 덮어씌워진 상태
 *  3. map 에도 2번 작업에 맞춰 이동한 값의 nums 에서의 인덱스 값을 삭제 대상의 nums 내 마지막 인덱스 값으로 갱신
 *  4. 삭제된 결과 map 의 values 에 갱신
 *      - 만약 삭제한 놈이 마지막 남은 값이였으면 map 에서 완전 삭제, 아니면 map 의 values 의 마지막 값 삭제
 *  5. 삭제된 결과 nums 에 갱신
 *      - nums 의 마지막 값 삭제 (= 실제 마지막 값은 삭제 대상의 마지막 위치로 이동 완료된 상태)
 *  ex)
 *  현재
 *  - map: {1: [0, 2], 2: [0, 3]}
 *  - nums: [[1, 0], [2, 0], [1, 1], [2, 1]]
 *  delete 1
 *   1) map 내 삭제 대상의 nums 내 마지막 인덱스: 2
 *   2) nums[2] 에 nums의 마지막 값을 overwrite
 *      - map: {1: [0, 2], 2: [0, 3]}
 *      - nums: [[1, 0], [2, 0], [2, 1], [2, 1]] // [1,1] 이 [2,1] 로 덮어씌워짐
 *   3) maps 에도 2) 의 작업 반영
 *      - map: {1: [0, 2], 2: [0, 2]} // 2 의 마지막 값이 3 -> 2로 변경
 *      - nums: [[1, 0], [2, 0], [2, 1], [2, 1]]
 *   4) 삭제된 결과 map 의 values 에 갱신
 *      - map: {1: [0], 2: [0, 2]} // 삭제된 1 의 마지막 인덱스 값인 1 삭제
 *      - nums: [[1, 0], [2, 0], [2, 1], [2, 1]]
 *   5) 삭제된 결과 nums 에 갱신
 *      - map: {1: [0], 2: [0, 2]}
 *      - nums: [[1, 0], [2, 0], [2, 1]] // 실제 마지막 값인 [2,1] 은 이미 삭제 대상의 마지막 위치 (= idx 2) 로 이동 완료된 상태임을 반영
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-10
 */
class RandomizedCollection {

    private val map = mutableMapOf<Int, MutableList<Int>>() // {val: [nums 내 val의 인덱스들]}
    private val nums = mutableListOf<IntArray>() // [val, map 내 마지막 인덱스]

    fun insert(`val`: Int): Boolean {
        val exist = map.contains(`val`)
        if (!exist) {
            map[`val`] = mutableListOf()
        }
        map[`val`]!!.add(nums.size)
        nums.add(intArrayOf(`val`, map[`val`]!!.size - 1))
        return !exist
    }

    fun remove(`val`: Int): Boolean {
        val exist = map.contains(`val`)
        if (exist) {
            val vals = map[`val`]!!
            val lastIdx = vals.last()

            val swapNum = nums.last()
            val (swapVal, swapIdx) = swapNum

            map[swapVal]!![swapIdx] = lastIdx
            nums[lastIdx] = swapNum

            if (vals.size == 1) {
                map.remove(`val`)
            } else {
                vals.removeAt(vals.size - 1)
            }
            nums.removeAt(nums.size - 1)
        }
        return exist
    }

    fun getRandom(): Int {
        return nums[Random.nextInt(nums.size)][0]
    }
}
