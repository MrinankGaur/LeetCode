// class Solution {
//     public int removeDuplicates(int[] nums) {
//         // int index = 0;
//         // for(int i = 0;i<nums.length;i++){
//         //     if(nums[index]!=nums[i]){
//         //         nums[++index]=nums[i];
//         //     }
//         // }
//         // return index+1;
//         int k=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[k]!=nums[i]){
//                 nums[++k]=nums[i];      
//             }
//         } 
//         return k+1;
//     }
// }
class Solution {
    public int removeDuplicates(int[] nums) {
      int k=0;
      for(int i=0;i<nums.length;i++){
        if(nums[k]!=nums[i]){
            nums[++k]=nums[i];      
        }
      } 
     return k+1;
    }
}