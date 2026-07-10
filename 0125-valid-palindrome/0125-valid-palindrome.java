class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if((ch>='a' && ch<='z') ||
            (ch>='0' && ch<='9')){
            // if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        
        int i=0,j=sb.length()-1;
        while(i<=j){
          if(sb.charAt(i)!=sb.charAt(j))
            return false;
          i++;
          j--;
        }
        return true;
    }
}