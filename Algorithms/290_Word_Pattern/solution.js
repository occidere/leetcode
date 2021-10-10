/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
const wordPattern = (pattern, s) => {
  const ws = s.split(" ");
  const [pLen, sLen] = [pattern.length, ws.length];
  if (pLen !== sLen) {
    return false;
  }
  const [mapping, memorized] = [new Map(), new Set()];
  for (let i = 0; i < ws.length; ++i) {
    const [p, w] = [pattern.charAt(i), ws[i]];
    if (mapping.has(p)) {
      if (mapping.get(p) !== w) {
        return false;
      }
    } else {
      if (memorized.has(w)) {
        return false;
      } else {
        memorized.add(w);
        mapping.set(p, w);
      }
    }
  }
  return true;
};
