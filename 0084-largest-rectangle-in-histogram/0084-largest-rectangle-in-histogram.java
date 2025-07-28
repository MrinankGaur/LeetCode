class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int heightIndex = st.pop();
                int height = arr[heightIndex];
                int rightBoundary = i;
                int leftBoundary = st.isEmpty() ? -1 : st.peek();
                int width = rightBoundary - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int heightIndex = st.pop();
            int height = arr[heightIndex];
            int rightBoundary = n;
            int leftBoundary = st.isEmpty() ? -1 : st.peek();
            int width = rightBoundary - leftBoundary - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
