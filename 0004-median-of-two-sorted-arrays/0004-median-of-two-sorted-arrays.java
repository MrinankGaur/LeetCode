class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n+m];
        int k = 0;
        for(int i = 0;i<n;i++){
            arr[k++] = nums1[i];
        }
        for(int i = 0;i<m;i++){
            arr[k++] = nums2[i];
        }

        Arrays.sort(arr);

        int total = arr.length;
        if(total%2==1){
            return (double) arr[total/2];
        }else{
            int middle1 = arr[total / 2 - 1];
            int middle2 = arr[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }
    }
}