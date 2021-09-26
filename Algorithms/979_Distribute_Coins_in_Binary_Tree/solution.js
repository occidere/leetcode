/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * 솔루션 참고함: https://leetcode.com/problems/distribute-coins-in-binary-tree/solution/
 * @param {TreeNode} root
 * @return {number}
 */
const distributeCoins = function (root) {
  let ans = 0;

  const dfs = (node) => {
    if (node == null) {
      return 0;
    }
    const [l, r] = [dfs(node.left), dfs(node.right)];
    ans += Math.abs(l) + Math.abs(r);
    return node.val + l + r - 1;
  };

  dfs(root);

  return ans;
};
