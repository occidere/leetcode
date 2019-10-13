# @param {Integer} n
# @return {Boolean}
def is_power_of_three(n)
  n > 0 and (n == 1 or (n % 3 == 0 and is_power_of_three(n / 3)))
end