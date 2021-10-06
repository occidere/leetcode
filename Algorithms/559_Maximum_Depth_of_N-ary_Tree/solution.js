/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @param {number} level
 * @return {number}
 */
const maxDepth = (root, level = 1) => {
  let maxLevel = root ? level : 0;
  if (root) {
    if (root.children) {
      for (const child of root.children) {
        maxLevel = Math.max(maxLevel, maxDepth(child, level + 1));
      }
    }
  }
  return maxLevel;
};
