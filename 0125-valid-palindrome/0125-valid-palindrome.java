class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            // if(Character.isLetterOrDigit(ch))
            if((ch>='a' && ch<='z')  || (ch>='0' && ch<='9'))
              sb.append(ch);
        }
        int left=0;
        int right=sb.length()-1;
        while(left<=right){
            if(sb.charAt(left)!=sb.charAt(right))
               return false;
            left++;
            right--;
        }
        return true;
    }
}