# @param {Integer[]} heights
# @return {Integer}
def largest_rectangle_area(heights)
  stk = []
  area = 0
  n = heights.length

  (0...n).each do |i|
    while not stk.empty? and heights[i] < heights[stk[-1]]
      h = heights[stk.pop]
      w = stk.empty? ? i : (i - stk[-1] - 1)

      area = [area, w * h].max
    end

    stk << i
  end

  until stk.empty?
    h = heights[stk.pop]
    w = stk.empty? ? n : (n - stk[-1] - 1)

    area = [area, w * h].max
  end

  area
end