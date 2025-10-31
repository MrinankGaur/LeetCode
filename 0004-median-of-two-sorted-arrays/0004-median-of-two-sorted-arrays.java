class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int totalLength = n + m;
        int[] arr = new int[n+m];
        int i = 0, j = 0;
        int k = 0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }
        if(i<n){
            while(k<totalLength){
                arr[k++] = nums1[i++];
            }
        }
        if(j<m){
            while(k<totalLength){
                arr[k++] = nums2[j++];
            }
        }
        double x =  0;
        if(totalLength%2==0){
            x = (arr[totalLength/2-1]+arr[totalLength/2])/2.0;
        }else{
            x = arr[totalLength/2];
        }
        return x;
    }
}