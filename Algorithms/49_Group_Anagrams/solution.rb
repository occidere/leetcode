# @param {String[]} strs
# @return {String[][]}
def group_anagrams(strs)
  anagram = Hash.new []
  strs.each { |s| anagram[s.each_char.sort_by { |c| c.chr }.join('')] += [s] }
  anagram.values
end


p group_anagrams(%w(eat tea tan ate nat bat))