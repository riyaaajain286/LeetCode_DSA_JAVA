class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int penalty=0;
        //Initial penalty when shop closes at hour 0 or shop is closed
        for(char ch:customers.toCharArray()){
            if(ch=='Y')  penalty++;
        }
        int minPenalty=penalty;
        //now our shop opens
       // Move closing hour
       int ct=0;
       for(int i=0;i<n;i++){
          if(customers.charAt(i)=='Y')
            penalty--;
          else
            penalty++;

         if(penalty<minPenalty){
            minPenalty=penalty;
            ct=i+1;
         }
       }
       return ct;
    }
}