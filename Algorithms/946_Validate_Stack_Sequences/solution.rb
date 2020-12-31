# @param {Integer[]} pushed
# @param {Integer[]} popped
# @return {Boolean}
def validate_stack_sequences(pushed, popped)
  stk, i = [], 0
  pushed.each do |element|
    stk << element
    while !stk.empty? && stk[-1] == popped[i]
      stk.pop
      i += 1
    end
  end
  stk.empty?
end