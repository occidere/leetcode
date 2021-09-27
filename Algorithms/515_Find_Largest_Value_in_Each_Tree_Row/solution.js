/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
const largestValues = (root) => {
  const largestByLevel = new Map();

  const dfs = (node, level = 0) => {
    if (node) {
      if (!largestByLevel.has(level)) {
        largestByLevel.set(level, node.val);
      }
      largestByLevel.set(level, Math.max(largestByLevel.get(level), node.val));

      dfs(node.left, level + 1);
      dfs(node.right, level + 1);

      return Array.from(largestByLevel.values());
    }
  }

  dfs(root);

  return Array.from(largestByLevel.values());
};
