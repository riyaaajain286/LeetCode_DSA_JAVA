class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int n:bills){
            if(n==5){
                five++;
            }
            else if(n==10){
                if(five>0){
                    five-=1;
                    ten+=1;
                }
                else{
                    return false;
                }
            }
            //for 20
            else{
                if(five>0 && ten>0){
                    five-=1;
                    ten-=1;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}