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
    public boolean isUnivalTree(TreeNode root) {
        if(root ==null){
            return true;
        }
        return findUniVal(root,root.val);
    }
    public boolean findUniVal(TreeNode root, int val){
       if(root ==null){
           return true;
       }
        if(root.val ==val){
            return findUniVal(root.left, val) && findUniVal(root.right,val);
        }
        return false;
    }
}