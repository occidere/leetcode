# @param {String} s
# @param {String} t
# @return {String}
def min_window(s, t)
  w_freq, t_freq = Hash.new(0), t.each_char.group_by(&:itself).transform_values(&:count)

  cur_match, all_match = 0, t_freq.length
  min_window_str, min_window_len = '', s.length + 1

  l, r = 0, 0
  while r < s.length
    r_char = s[r]
    w_freq[r_char] += 1
    cur_match += 1 if t_freq[r_char] and w_freq[r_char] == t_freq[r_char]

    while cur_match == all_match and l <= r
      min_window_len, min_window_str = r - l + 1, s[l..r] if r - l + 1 < min_window_len

      l_char = s[l]
      w_freq[l_char] -= 1
      cur_match -= 1 if t_freq[l_char] and w_freq[l_char] < t_freq[l_char]

      l += 1
    end

    r += 1
  end

  min_window_str
end