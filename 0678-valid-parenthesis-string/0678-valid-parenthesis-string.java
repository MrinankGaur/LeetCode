class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        for(char it:s.toCharArray()){
            if(it=='('){
                leftMin++; 
                leftMax++;
            }
            else if(it==')'){
                leftMin--; 
                leftMax--;
            }
            else{   
                leftMin--; 
                leftMax++;
            }
            if(leftMax<0) return false;
            if(leftMin<0) leftMin = 0;
        }
        return leftMin == 0;
    }
}