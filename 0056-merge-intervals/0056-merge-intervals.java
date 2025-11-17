class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[][] ans=new int[n][2];
        int index=0;
        for(int i=0;i<n;i++){
            //if no interval added or no overlap add new interval
            if(index==0||intervals[i][0]>ans[index-1][1]){
                ans[index++]=new int[]{intervals[i][0],intervals[i][1]};
            }
            else{
                //merge intervals by updating end value
                ans[index-1][1]=Math.max(intervals[i][1],ans[index-1][1]);
            }
        }
        return Arrays.copyOf(ans,index);
    }
}