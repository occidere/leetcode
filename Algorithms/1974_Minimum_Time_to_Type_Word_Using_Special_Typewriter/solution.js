/**
 * @param {string} word
 * @return {number}
 */
const minTimeToType = word => {
  let p = 0;
  return word.split('')
    .map(w => {
      const c = w.charCodeAt(0) - 97;
      const sec = 1 + (p < c ? Math.min(c - p, 26 - c + p) : Math.min(p - c, 26 - p + c));
      p = c;
      return sec;
    }).reduce((x, y) => x + y, 0);
};
