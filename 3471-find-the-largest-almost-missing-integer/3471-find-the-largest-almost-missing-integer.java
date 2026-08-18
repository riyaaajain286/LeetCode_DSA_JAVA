class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int ans=-1;
       // Number of windows in which each number appears
        int[] freq=new int[51];
        for(int l=0;l<=n-k;l++){
             // Store which elements are present in this window
            boolean[] seen=new boolean[51];
            for(int i=l;i<l+k;i++)
                seen[nums[i]]=true;
            
             // Count this window for every distinct element
             for(int i=0;i<=50;i++){
                if(seen[i])
                    freq[i]++;
             }
          }
        
         // Find largest element appearing in exactly one window
         for(int i=0;i<=50;i++){
            if(freq[i]==1)
                ans=i;
         }  
        return ans;
    }
}