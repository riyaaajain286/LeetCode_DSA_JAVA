class Solution {
    public int strStr(String haystack, String needle) {
   int m=haystack.length();
        int n=needle.length();
        for(int i=0;i<m-n+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                {
                    if(haystack.substring(i,n+i).equals(needle)){
                        return i;
                    }
                }
            }
        }
        return -1; 
    }
}