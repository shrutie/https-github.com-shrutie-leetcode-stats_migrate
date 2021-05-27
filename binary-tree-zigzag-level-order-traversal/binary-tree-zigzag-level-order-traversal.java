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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean even = true;
        if(root == null){
            return res;
        }
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                if(!even){
                    list.add(0,curr.val);
                }
                else{
                    list.add(curr.val);
                }
                if(curr.left != null){
                    que.add(curr.left);
                }
                if(curr.right != null){
                    que.add(curr.right);
                }
                
            }
            res.add(list);
            even = !even;
        }
        return res;
    }
}