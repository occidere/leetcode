# @param {Integer} n
# @return {Integer}
def count_primes(n)
  Prime.new(n).count
end

class Prime
  attr_reader :count

  def initialize(n)
    @count = (eratosthenes n).sum
  end

  private

  def eratosthenes(n)
    primes, i = Array.new(n) { |k| k > 1 ? 1 : 0 }, 2
    while i * i < n
      if primes[i] == 1 and (j = i * i)
        primes[j], j = 0, j + i while j < n
      end
      i += 1
    end
    primes
  end
end