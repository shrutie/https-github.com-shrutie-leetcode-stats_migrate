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
    int dia =0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return dia;
    }
    
    public int findDia(TreeNode root){
        if(root == null)
            return 0;
        
        int leftHt = findDia(root.left);
        int rightHt = findDia(root.right);
        dia = Math.max(dia, leftHt+rightHt);
        
        return Math.max(leftHt, rightHt)+1;
    }
}