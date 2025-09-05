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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int width = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0, last = 0;
            int min = q.peek().index;
            for(int i = 0;i<size;i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int index = curr.index-min;
                if(i==0) first = index;
                if(i==size-1) last = index;
                if(node.left!=null){
                q.offer(new Pair(node.left,2*index +1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,2*index +2));
                }
            }
            width = Math.max(width,last-first+1);
            
        }
        return width;
    }


}
class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode node,int index){
        this.node = node;
        this.index = index;
    }
}