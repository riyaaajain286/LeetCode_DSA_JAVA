class Solution {
    //in this to insert an interval and if they are overlapping then take the entire range as a single interval...also divide intervals as left,newinterval and right part
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] ans=new int[n+1][2];
        int indx=0;
        int i=0;
        //for left part i.e. end<start of new interval
        while(i<n && intervals[i][1]<newInterval[0]){
            ans[indx++]=intervals[i];
            i++;
        }
        //for new interval merge i.e. start<new interval's end
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
         ans[indx++]=newInterval;
        //right part
        while(i<n){
             ans[indx++]=intervals[i];
            i=i+1;
        }
        return Arrays.copyOf(ans,indx);
    }
}