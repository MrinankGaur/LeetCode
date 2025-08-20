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
        List<List<Integer>> list = new ArrayList<>();
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = q.poll();
                if(level%2==0){
                    arr.add(curr.val);
                }else{
                    arr.addFirst(curr.val);
                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            level++;
            list.add(arr);
        }
        return list;
    }
}