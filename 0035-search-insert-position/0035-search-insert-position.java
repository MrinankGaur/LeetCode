class Solution {
    public int searchInsert(int[] x, int y) {
        int start = 0;
        int end  = x.length-1;
        int mid =  0;
        while(start<=end){
            mid = start + (end-start)/2;
            if(y>x[mid]){
                start = mid+1;
            } else if (y<x[mid]) {
                end = mid-1;
            }else{
                return mid;
            }
        }
        return start;
    }
}