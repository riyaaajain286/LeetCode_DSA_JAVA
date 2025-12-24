class Solution {
    public int findNumbers(int[] nums) {
          int cnt=0;
       for(int num:nums){
          int digit=cntdigits(num);
          boolean even=evenno(digit);
        
          if(even==true){
           cnt++;
          }

       } 
       return cnt;
    }
    public int cntdigits(int num){
        int digits=0;
       if(num==0) return 1;
       while(num!=0){
        num/=10;
        digits++;
       }
        return digits;
      }
    public boolean evenno(int digit){
        if(digit%2==0){
            return true;
        }
        return false;
    }
}