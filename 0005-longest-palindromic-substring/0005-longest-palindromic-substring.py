class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            for j in range(i,len(s)):
                if self.isPalindrome(s,i,j):
                    current_substring = s[i:j+1]
                    if len(current_substring)>len(res):
                        res = current_substring
        return res
    def isPalindrome(self, s:str, start: int, end:int)->bool:
        while start< end:
            if(s[start]!=s[end]):
                return False
            start+=1
            end-=1
        return True