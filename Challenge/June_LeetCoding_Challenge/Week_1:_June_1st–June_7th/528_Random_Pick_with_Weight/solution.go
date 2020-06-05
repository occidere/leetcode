package main

import (
    "math/rand"
    "sort"
)

type Solution struct {
    weights []KV // 인덱스와 그 가중치가 '가중치의 오름차순'으로 정렬된 리스트
}

type KV struct {
    index  int
    weight float64
}

func Constructor(w []int) Solution {
    // 만약 w = {1, 3} 일 때
    total := 0 // 가중치의 총합 -> 4
    for _, weight := range w {
        total += weight
    }

    weights := make([]KV, len(w), len(w))
    for i, weight := range w {
        // KV{index: 인덱스, weight: 현재 가중치 / 총 가중치}
        weights[i] = KV{i, float64(weight) / float64(total)}
    }

    // 가중치의 오름차순 정럴 -> {{0, 0.25}, {1, 0.75}}
    sort.Slice(weights, func(i, j int) bool {
        return weights[i].weight < weights[j].weight
    })
    return Solution{weights}
}

/*
# 누적확률값을 사용한 가중치 랜덤 추출
1. 먼저 기준값이 될 랜덤값을 생성 (boundary)
2. 가중치가 오름차순으로 정렬된 리스트를 순회하며 누적 합산 (acc)
3. 누적 가중치 합(acc)이 기준 랜덤값(boudary) 이상이 되는 순간에 해당하는 인덱스를 선택
*/
func (s *Solution) PickIndex() int {
    boundary := rand.Float64() // 0.0 ~ 1.0
    acc := 0.0
    for _, kv := range s.weights {
        acc += kv.weight
        if boundary <= acc {
            return kv.index
        }
    }
    return 0
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(w);
 * param_1 := obj.PickIndex();
 */
