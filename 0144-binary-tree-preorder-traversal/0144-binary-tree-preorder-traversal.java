/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    // Pure recursive tree architecture helper
    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        result.add(node.val);          // 1. Visit Root
        traverse(node.left, result);   // 2. Traverse Left
        traverse(node.right, result);  // 3. Traverse Right
    }
}