class Solution {
    //sliding window
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxUnsat=0,curUnsat=0;
        int n=customers.length;
        for(int i=0;i<minutes;i++){//calc initial window unsatisfies cust
           if(grumpy[i]==1)
            curUnsat+=customers[i];
        }
        maxUnsat=curUnsat;//can satisfy them at end
        int i=0;
        int j=minutes;
        while(j<n){
           curUnsat+=customers[j]*grumpy[j];//add nextone if grumpy
           curUnsat-=customers[i]*grumpy[i]; //delete previous if grumpy
           maxUnsat=Math.max(maxUnsat,curUnsat);
           i++;
           j++;
        }
        int totalsum=maxUnsat;
        for(int k=0;k<n;k++){
            if(grumpy[k]==0){
                totalsum+=customers[k];
            }

        }
        return totalsum;
  }
}