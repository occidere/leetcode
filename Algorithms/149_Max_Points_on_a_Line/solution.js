/**
 * Ref: https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes
 * @param {number[][]} points
 * @return {number}
 */
const maxPoints = points => {
  if (points == null) {
    return 0;
  } else if (points.length <= 2) {
    return points.length;
  }

  const getGcd = (a, b) => b === 0 ? a : getGcd(b, a % b);
  const map = new Map();
  let res = 0;
  for (let i = 0; i < points.length; ++i) {
    map.clear();
    let [overlap, max] = [0, 0];
    for (let j = i + 1; j < points.length; ++j) {
      let [x, y] = [points[j][0] - points[i][0], points[j][1] - points[i][1]];
      if (x === 0 && y === 0) {
        ++overlap;
        continue;
      }

      const gcd = getGcd(x, y);
      if (gcd !== 0) {
        x /= gcd;
        y /= gcd;
      }

      if (map.has(x)) {
        if (map.get(x).has(y)) {
          map.get(x).set(y, map.get(x).get(y) + 1);
        } else {
          map.get(x).set(y, 1);
        }
      } else {
        const m = new Map();
        m.set(y, 1);
        map.set(x, m);
      }
      max = Math.max(max, map.get(x).get(y));
    }
    res = Math.max(res, max + overlap + 1);
  }
  return res;
};
