/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        ListNode temp = head;
        while(top<=bottom && left<=right){
            for(int i = left;i<=right;i++){
                if(temp!=null){
                    matrix[top][i]=temp.val;
                    temp=temp.next;
                }else{
                    matrix[top][i]=-1;
                }
            }
            top++;
            for(int i = top;i<=bottom;i++){
                if(temp!=null){
                    matrix[i][right]=temp.val;
                    temp=temp.next;
                }else{
                    matrix[i][right]=-1;
                }
            }
            right--;
            if(top<=bottom){
                for(int i = right;i>=left;i--){
                    if(temp!=null){
                        matrix[bottom][i]=temp.val;
                        temp=temp.next;
                    }else{
                        matrix[bottom][i]=-1;
                    }
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom;i>=top;i--){
                    if(temp!=null){
                        matrix[i][left]=temp.val;
                        temp=temp.next;
                    }else{
                        matrix[i][left]=-1;
                    }
                }
                left++;
            }
        }
        return matrix;
    }
}