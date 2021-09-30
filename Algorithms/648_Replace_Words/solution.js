/**
 * @param {string[]} dictionary
 * @param {string} sentence
 * @return {string}
 */
const replaceWords = (dictionary, sentence) => {
  dictionary = dictionary.sort((a, b) => a.length - b.length);
  return sentence.split(" ")
    .map(s => {
      const sLen = s.length;
      for (const w of dictionary) {
        if (sLen > w.length && s.startsWith(w)) {
          return w
        }
      }
      return s;
    }).join(" ");
};
