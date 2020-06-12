package main

import (
	"math/rand"
)

type RandomizedSet struct {
	set map[int]int
}

/** Initialize your data structure here. */
func Constructor() RandomizedSet {
	return RandomizedSet{make(map[int]int)}
}

/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
func (rs *RandomizedSet) Insert(val int) bool {
	if rs.set[val] == 0 {
		rs.set[val] = 1
		return true
	}
	return false
}

/** Removes a value from the set. Returns true if the set contained the specified element. */
func (rs *RandomizedSet) Remove(val int) bool {
	if rs.set[val] != 0 {
		delete(rs.set, val)
		return true
	}
	return false
}

/** Get a random element from the set. */
func (rs *RandomizedSet) GetRandom() int {
	keys := []int{}
	for k := range rs.set {
		keys = append(keys, k)
	}
	return keys[rand.Intn(len(keys))]
}