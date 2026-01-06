class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int water = 0;
        int w = 0;
        int h = 0;
        while(left<right){
            w = right-left;
            h = Math.min(height[left],height[right]);
            int currWater = h*w;
            water = Math.max(water,currWater);
            if(height[left]<height[right]){
                left++;
            }
            else if(height[right]<height[left]){
                right--;
            }
            else{
                right--;
            }
        }
        return water;
    }
}