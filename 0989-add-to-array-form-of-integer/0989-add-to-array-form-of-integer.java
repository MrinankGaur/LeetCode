import java.math.*;
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        BigInteger sum = 0;
        for(int i:num){
            sum = sum*10 + i;
        }
        System.out.println(sum);
        sum+=k;
        System.out.println(sum);
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();        
        while(sum>0){
            long digit =sum%10;
            System.out.println(digit);
            stack.push((int)digit);
            sum/=10;
        }
        while(!stack.isEmpty()){
            ans.add((int)stack.pop());
        }
       
       
        return ans;
    }
}