class Solution {
    public int largestAltitude(int[] gain) {
        int sum=0;
        int[] newgain=new int[gain.length+1];
        newgain[0]=0;
          int highest=0;
        for(int i=0;i<gain.length;i++){
            sum=gain[i]+sum;
            newgain[i+1]=sum;
            highest=Math.max(highest,newgain[i+1]);
        }
      return highest;
    }
}