function numRescueBoats(people: number[], limit: number): number {
  const sorted = people.sort((a, b) => a - b)
  let i = 0, j = sorted.length - 1, acc = 0

  for (; i < j; --j, ++acc) {
    if (sorted[i] + sorted[j] <= limit) {
      ++i
    }
  }

  return acc + (i == j ? 1 : 0)
}
