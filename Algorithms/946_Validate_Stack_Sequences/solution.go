func validateStackSequences(pushed []int, popped []int) bool {
    stk := make([]int, 0, 1000)
    i := 0

    for _, element := range pushed {
        stk = append(stk, element)
        for len(stk) > 0 && stk[len(stk)-1] == popped[i] {
            stk = stk[:len(stk)-1]
            i++
        }
    }

    return len(stk) == 0
}
