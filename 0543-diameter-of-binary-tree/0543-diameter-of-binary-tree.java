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
// class Solution {
//     int diameter = 0;
//     public int diameterOfBinaryTree(TreeNode root) {
//         height(root);
//         return diameter;
//     }
//     public int height(TreeNode node){
//         if(node==null){
//             return 0;
//         }
//         int leftHeight=height(node.left);
//         int rightHeight=height(node.left);
//         diameter = Math.max(leftHeight+rightHeight,diameter);
//         return Math.max(leftHeight,rightHeight)+1;
//     }
// }
class Solution {
    private int maxDiameter = 0;

    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }
}