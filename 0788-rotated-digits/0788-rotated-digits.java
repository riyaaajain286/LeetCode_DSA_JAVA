class Solution {
    public int rotatedDigits(int n) {
        int c=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
                c++;
            }
        }
        return c;
    }
    boolean isGood(int num){
      boolean diff=false;
      while(num>0){
        int d=num%10;
        // invalid digits
        if(d==3||d==4||d==7){
            return false;
        }
        if(d==2||d==5||d==6||d==9){
            diff=true;
        }
        num=num/10;
        }
       return diff; 
    }
}