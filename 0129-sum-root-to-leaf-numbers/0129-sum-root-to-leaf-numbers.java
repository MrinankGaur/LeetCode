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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
         
    }
    private int helper(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        sum = sum*10 + root.val;
        if(root.left == null && root.right==null){
            return sum;
        }
        return helper(root.right,sum)+helper(root.left,sum);
        

    }
}