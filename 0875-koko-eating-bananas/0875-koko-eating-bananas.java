class Solution {
    //in this answer lies in range therefore use BS on answer
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;

      // find max pile
     for(int p:piles){
      high=Math.max(p,high);
     }
     int ans=high;
     while(low<=high){
      int mid=low+(high-low)/2;
      long eatingHours=calculateHours(piles, mid);
      if(eatingHours<=h){
        ans=mid;
        high=mid-1; // try smaller speed
      }
      else{
        low=mid+1;// need faster speed
      }
    }
    return ans;
  }
  
  private static long calculateHours(int[] piles,int speed){
    long totalHours=0;
    for(int p:piles){
       totalHours+=(int)Math.ceil((double)p/speed);
    //   totalHours+=(p+speed-1)/speed;
    }
    return totalHours;
    }
}