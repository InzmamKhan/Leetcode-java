class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        int remainingSum = targetSum - root.val;
        
        if (root.left == null && root.right == null) {
            return remainingSum == 0;
        }
        
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}