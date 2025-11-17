class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[][] ans=new int[n][2];
        int index=0;
        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            int j=i+1;
           while(j<n&&intervals[j][0]<=end){
                end=Math.max(end,intervals[j][1]);
                j++;
            }
            ans[index++]=new int[]{start,end};
            i=j-1;
        }
       return Arrays.copyOf(ans,index);
    }
}