class Solution {
    public boolean isPalindrome(int x) {
        int copy=x;
        int rev=0;
        if(x==0){
            return true;
        }
        while(x>0){
            int d=x%10;
            rev=rev*10+d;
            x=x/10;
        }
        if(rev==copy&&rev!=-copy){
   return true;
        }
     return false;
    }
}