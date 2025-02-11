class Solution {
    public boolean mySqrt(int x) {
        
        if (x == 0 || x == 1)
            return true;

        
        int start = 1;
        int end = x;
        int mid = -1;

        
        while (start <= end) {
            
            mid = start + (end - start) / 2;

            
            if ((long) mid * mid > (long) x)
                end = mid - 1;
            else if (mid * mid == x)
                
                return true;
            else
             
                start = mid + 1;
        }

        
        return false;
    }
}