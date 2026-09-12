class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int totalEven=0,totalOdd=0;
            // Total even and odd index sums
        for(int j=0;j<n;j++){
            if(j%2==0)
                totalEven+=nums[j];
            else
                totalOdd+=nums[j];
        }
        int leftEven=0,leftOdd=0;
        int count=0;
        for(int i=0;i<n;i++){ 
                // Remove arr[i] from the total
        int rightEven=totalEven-leftEven;
        int rightOdd=totalOdd-leftOdd;

        if(i%2==0){
            rightEven-=nums[i];
        }
        else
            rightOdd-=nums[i];
            // After removing arr[i], right side shifts left
        int newOdd=leftOdd+rightEven;
        int newEven=leftEven+rightOdd;
        if(newOdd==newEven)
            count++;
        // Add current element to left side
        if(i%2==0)
            leftEven+=nums[i];
        else 
            leftOdd+=nums[i];

        }
        return count;
  }
}