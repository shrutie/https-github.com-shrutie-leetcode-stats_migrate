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
    public int pathSum(TreeNode root, int targetSum) {
        int count =0;
        if(root ==null){
            return 0;
        }
        count+= pathSum(root.left, targetSum);
        count+= pathSum(root.right, targetSum);
        count+= calcPathSum(root, targetSum);
        return count;
    }
    public int calcPathSum(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        
        int count =0;
        if(targetSum-root.val == 0){
            count++;
        }
        
        count+= calcPathSum(root.left, targetSum- root.val);
        count+= calcPathSum(root.right, targetSum- root.val);
        
        return count;
    }
}