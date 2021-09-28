/**
 * @param {string[]} operations
 * @return {number}
 */
const finalValueAfterOperations = operations => {
  return operations.map(x => x.indexOf("++") > -1 ? 1 : -1).reduce((x, y) => x + y, 0);
};
