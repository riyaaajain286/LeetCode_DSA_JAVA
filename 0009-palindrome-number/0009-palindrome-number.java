class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
      String str=Integer.toString(x);
      int i=0;
      int len=str.length();
      int j=len-1;
      while(i<=j){
        if(str.charAt(i)!=str.charAt(j)){
            return false;
        }
        i++;
        j--;
      }
      return true;
    }
}