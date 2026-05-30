import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        findPaths(root, targetSum, currentPath, result);
        
        return result;
    }

    private void findPaths(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        int remainingSum = targetSum - root.val;
        currentPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (remainingSum == 0) {
                result.add(new ArrayList<>(currentPath));
            }
        }
        else {
            findPaths(root.left, remainingSum, currentPath, result);
            findPaths(root.right, remainingSum, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}