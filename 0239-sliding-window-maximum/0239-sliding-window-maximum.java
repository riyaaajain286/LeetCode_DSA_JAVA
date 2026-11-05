class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        //deque stores nums index
        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[n-k+1];
        int ind=0;
        // for(int i=0;i<k;i++){
        //     dq.addLast(i);
        //     ans[ind]=dq.front();
        // }
        for(int i=0;i<n;i++){
            //1.  Remove smaller elements from the back
           while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
            dq.pollLast();
           }
          
        // 2.   Remove indices outside the window
           while(!dq.isEmpty() && dq.peekFirst()<=i-k)
             dq.pollFirst();
           
             // 3. Add current index
           dq.addLast(i);
            // 4. Store maximum when window is complete
            if(i>=k-1){
                ans[ind]=nums[dq.peekFirst()];
                ind++;
            }
        }
        return ans;
    }
}