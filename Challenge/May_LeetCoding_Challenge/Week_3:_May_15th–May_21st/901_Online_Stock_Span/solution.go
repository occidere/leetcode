package main

type StockSpanner struct {
    stack [10000][2]int
    size  int
}

func Constructor() StockSpanner {
    return StockSpanner{}
}

func (s *StockSpanner) Next(price int) int {
    span := 1
    for ; s.size > 0; s.size-- {
        top := s.stack[s.size-1]
        if top[0] > price {
            break
        }
        span += top[1]
    }
    s.stack[s.size] = [2]int{price, span}
    s.size++
    return span
}
