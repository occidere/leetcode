# frozen_string_literal: true
# @param [String] sentence
# @return [String]
def to_goat_latin(sentence)
  sentence.split(' ')
          .each_with_index
          .map { |x, i| ('aeiouAEIOU'.include?(x[0]) ? x : x[1, x.size] + x[0]) + "m#{(0...i + 2).map { 'a' }.join}" }
          .join(' ')
end
