class SparseVector {
  nums: number[]

  constructor(nums: number[]) {
    this.nums = nums
  }

  // Return the dotProduct of two sparse vectors
  dotProduct(vec: SparseVector): number {
    let acc = 0
    this.nums.forEach((v, i) => acc += v * vec.nums[i])
    return acc
  }
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * var v1 = new SparseVector(nums1)
 * var v2 = new SparseVector(nums1)
 * var ans = v1.dotProduct(v2)
 */

