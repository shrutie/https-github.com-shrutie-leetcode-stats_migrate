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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        List<Integer> leaves1= new ArrayList<>();
        dfs(root1, leaves1);
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root2, leaves2);
        //System.out.println(leaves1);
        //System.out.println(leaves2);
        return (leaves1.equals(leaves2));
    }
    
    public List<Integer> dfs(TreeNode root, List<Integer> leaves){
        if(root==null){
            return leaves;
        }
        if(root.left==null && root.right==null){
            leaves.add(root.val);
        }
        else{
            dfs(root.left, leaves);
            dfs(root.right, leaves);
        }
        return leaves;
        
    }
}