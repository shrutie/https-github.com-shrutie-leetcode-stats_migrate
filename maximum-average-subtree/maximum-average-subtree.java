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
    double res;
    public double maximumAverageSubtree(TreeNode root) {
        calcAvg(root);
        return res;
    }
    
    int[] calcAvg(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }
        int[] left = calcAvg(node.left);
        int[] right = calcAvg(node.right);
        int sumOfNodes = left[0] + right[0] + node.val;
        int countOfNodes = left[1] + right[1] + 1;
        res = Math.max(res, (double) sumOfNodes/countOfNodes);
        return new int[]{sumOfNodes, countOfNodes};
    }
}