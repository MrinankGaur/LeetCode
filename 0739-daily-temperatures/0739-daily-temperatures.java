public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i = 0;i<n;i++){
            int t = temperatures[i];
            while(!st.isEmpty() && t>st.peek()[0]){
                int[] curr = st.pop();
                result[curr[1]] = i-curr[1];
            }
            st.push(new int[]{t,i});
        }
        return result;
        // int[] res = new int[temperatures.length];
        // Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        // for (int i = 0; i < temperatures.length; i++) {
        //     int t = temperatures[i];
        //     while (!stack.isEmpty() && t > stack.peek()[0]) {
        //         int[] pair = stack.pop();
        //         res[pair[1]] = i - pair[1];
        //     }
        //     stack.push(new int[]{t, i});
        // }
        // return res;
    }
}
