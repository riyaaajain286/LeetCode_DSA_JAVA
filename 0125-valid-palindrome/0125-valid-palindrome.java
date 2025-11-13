class Solution {
    public boolean isPalindrome(String s) {
      s=s.toLowerCase();
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(Character.isLetterOrDigit(c)){
            sb.append(c);
        }
      }
      int p=0;
      int q=sb.length()-1;
      while(p<=q){
        if(sb.charAt(p)!=sb.charAt(q)){
          return false;
        }
        p++;
        q--;
      }
      return true;
    }
}