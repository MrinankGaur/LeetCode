class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email:emails){
            String[] parts = email.split("@");
            String localName = parts[0];
            String domainName = parts[1];

            char[] arr1 = localName.toCharArray();
            String temp = "";
            for(int i = 0;i<arr1.length;i++){
                if(arr1[i]=='+'){
                    localName = localName.substring(0,i);
                    break;
                }
                if(arr1[i]!='.'){
                   temp+=arr1[i];
                }
                
            }
            localName = temp;

            String newEmail = localName + "@" + domainName;
            set.add(newEmail);
        }
        return set.size();
    }
}