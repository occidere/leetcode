# @param {Integer} n
# @return {String}
def convert_to_title(n)
  n < 27 ? (n + 64).chr : convert_to_title((n - 1) / 26) + convert_to_title(((n - 1) % 26) + 1)
end
