class Solution {
    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
       if(digits==null || digits.length()==0){
        return res;
       }
       Map<Character,String> map = new HashMap<>();
       map.put('2',"abc");
       map.put('3',"def");
       map.put('4',"ghi");
       map.put('5',"jkl");
       map.put('6',"mno");
       map.put('7',"pqrs");
       map.put('8',"tuv");
       map.put('9',"wxyz");
       bt(digits,0,new StringBuilder(),res,map);
       return res;

    }

    private void bt(String digits, int idx,StringBuilder comb, List<String> result, Map<Character,String> map){
        if(idx==digits.length()){
            result.add(comb.toString());
            return;
        }

        String lts = map.get(digits.charAt(idx));
        for(char it : lts.toCharArray()){
            comb.append(it);
            bt(digits,idx+1,comb,result,map);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}