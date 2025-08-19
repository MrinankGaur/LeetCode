class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candyL = new int[n];
        int[] candyR = new int[n];
        Arrays.fill(candyL,1);
        Arrays.fill(candyR,1);
        for(int i = 1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candyL[i]=candyL[i-1]+1;
            }
        }
        int sum =0;
        for(int i = n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candyR[i]=candyR[i+1]+1;
            }
        }
        for(int i = 0;i<n;i++){
            sum += Math.max(candyL[i],candyR[i]);
        }
        return sum;
    }
}