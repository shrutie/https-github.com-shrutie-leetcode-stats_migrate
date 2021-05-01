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
    int maxm = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxm;
    }
    
    public int findMaxPath(TreeNode root){
        if(root ==null){
            return 0;
        }
        
        int leftHeight = Math.max(findMaxPath(root.left),0);
        int rightHeight = Math.max(findMaxPath(root.right),0);
        
        int height = leftHeight+rightHeight+ root.val;
        
        maxm = Math.max(maxm, height);
        
        return Math.max(leftHeight, rightHeight)+ root.val;
    }
    
}