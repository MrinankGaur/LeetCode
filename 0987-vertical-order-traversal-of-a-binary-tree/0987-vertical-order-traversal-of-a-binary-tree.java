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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        TreeNode temp = root;
        ArrayList<Tuple> arr = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0,0,root));
        arr.add(new Tuple(0,0,root));
        int left = 0,right=0;
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            TreeNode node = curr.node;
            right = Math.max(right,j);
            left = Math.min(left,j);
            if(node.left!=null){
                q.offer(new Tuple(i+1,j-1,node.left));
                arr.add(new Tuple(i+1,j-1,node.left));
            }
            if(node.right!=null){
                q.offer(new Tuple(i+1,j+1,node.right));
                arr.add(new Tuple(i+1,j+1,node.right));
            }
        }
        Collections.sort(arr, (a, b) -> {
            if (a.j != b.j) return a.j - b.j;   
            if (a.i != b.i) return a.i - b.i;   
            return a.node.val - b.node.val;     
        });
        for(int i =0;i<(right-left+1);i++){
            list.add(new ArrayList<>());
        }
        for(Tuple it:arr){
            int j = it.j;
            list.get(j-left).add(it.node.val);
        }

        
        return list;

    }
    public class Tuple{
        int i,j;
        TreeNode node;
        public Tuple(int i,int j,TreeNode node){
            this.i = i;
            this.j = j;
            this.node = node;
        }
    }
}