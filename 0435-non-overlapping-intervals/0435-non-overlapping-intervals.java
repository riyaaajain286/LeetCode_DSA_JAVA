class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int n=intervals.length;
        int i=0,cnt=1;// first interval is always kept
        for(int j=1;j<n;j++){
            int s1=intervals[i][0];
            int e1=intervals[i][1];
            int s2=intervals[j][0];
            int e2=intervals[j][1];
            // boolean overlap=s2<=e1;
            if(s2>=e1){//no overlap condition
                cnt++;
                i=j;
            }
            else{
                if(e2<e1){//overlap
                    i=j;// keep interval with smaller end
                }
            }

        }
        return n-cnt;

    }
}