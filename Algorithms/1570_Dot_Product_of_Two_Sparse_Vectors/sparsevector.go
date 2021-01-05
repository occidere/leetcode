package main

type SparseVector struct {
	nums []int
}

func Constructor(nums []int) SparseVector {
	return SparseVector{nums}
}

// Return the dotProduct of two sparse vectors
func (sv *SparseVector) dotProduct(vec SparseVector) int {
	acc := 0
	for i, v := range sv.nums {
		acc += v * vec.nums[i]
	}
	return acc
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * v1 := Constructor(nums1);
 * v2 := Constructor(nums2);
 * ans := v1.dotProduct(v2);
 */
