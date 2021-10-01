/**
 * @param {string} s
 * @return {number}
 */
const numSplits = s => {
  Map.prototype.getOrDefault = function (k, v) {
    return this.has(k) ? this.get(k) : v;
  }
  Map.prototype.remove = function (k) {
    let v = this.getOrDefault(k, 0);
    --v === 0 ? this.delete(k) : this.set(k, v);
  }
  const [grpA, grpB] = [new Map(), new Map()];

  s.split('').forEach(x => {
    grpB.set(x, grpB.getOrDefault(x, 0) + 1);
  });

  let ans = 0;
  for (let i = 0; i < s.length; ++i) {
    grpA.set(s[i], grpA.getOrDefault(s[i], 0) + 1);
    grpB.remove(s[i]);
    if (grpA.size === grpB.size) {
      ++ans;
    }
  }
  return ans;
};
