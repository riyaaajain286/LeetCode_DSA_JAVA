class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
         PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));

        for(int t : workerTimes){
            pq.offer(new long[]{t, t, 1});
        }

        long ans = 0;

        while(mountainHeight > 0){
            long[] cur = pq.poll();

            long finishTime = cur[0];
            long base = cur[1];
            long k = cur[2];

            ans = finishTime;

            k++;
            long nextTime = finishTime + base * k;

            pq.offer(new long[]{nextTime, base, k});

            mountainHeight--;
        }

        return ans;
    }
}