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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        HashMap<Integer, List<Integer>> colMap = new HashMap<>();
        
        que.add(new Pair<>(root,0));
        
        while(!que.isEmpty()){
            Pair<TreeNode, Integer> curr = que.poll();
            int col = curr.getValue();
            TreeNode currNode = curr.getKey();
            
            if(!colMap.containsKey(col)){
                colMap.put(col, new ArrayList<Integer>());
            }
            colMap.get(col).add(currNode.val);
            
            if(currNode.left!=null){
                que.add(new Pair<>(currNode.left, col-1));
            }
            if(currNode.right!=null){
                que.add(new Pair<>(currNode.right, col+1));
            }
        }
        
        List<Integer> keys = new ArrayList<>(colMap.keySet());
        Collections.sort(keys);
        for(int key: keys){
            res.add(new ArrayList<Integer>(colMap.get(key)));
        }
    
        return res;
    }
}