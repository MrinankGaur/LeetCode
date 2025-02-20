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
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i =0;i<n;i++){
                
                if(!zigzag){
                    TreeNode currentNode = queue.pollFirst();
                    list.add(currentNode.val); 
                    if(currentNode.left != null){
                        queue.offerLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.offerLast(currentNode.right);
                    }            
                }else{
                    TreeNode currentNode = queue.pollLast();
                    list.add(currentNode.val); 
                    if(currentNode.right != null){
                        queue.offerFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.offerFirst(currentNode.left);
                    } 
                }
                
            }
            zigzag = !zigzag;
            ans.add(list);
        }
        return ans;
    }
}