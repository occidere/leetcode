class Solution {
  nums: number[]

  constructor(nums: number[]) {
    this.nums = nums

  }

  reset(): number[] {
    return this.nums
  }

  shuffle(): number[] {
    if (this.nums == null) {
      return null;
    }
    const cloned = this.nums.slice()
    for (let i = 0; i < cloned.length; ++i) {
      const j = Math.floor(Math.random() * cloned.length);
      const tmp = cloned[i]
      cloned[i] = cloned[j]
      cloned[j] = tmp
    }
    return cloned
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */
