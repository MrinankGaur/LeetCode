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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] arr = new int[1];
        dfs(root,root.val,arr);
        return arr[0];
    }
    public void dfs(TreeNode node, int greatest, int[] arr){
        if(node==null){
            return;
        }
        if(node.val>=greatest){
            arr[0]++;
        }
        greatest = Math.max(node.val,greatest);
        dfs(node.right,greatest,arr);
        dfs(node.left,greatest,arr);
    }
}