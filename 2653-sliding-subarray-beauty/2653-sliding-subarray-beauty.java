class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int[] result=new int[n-k+1];
         // frequency array for negatives [-50..-1]
         int[] freq=new int[51];
        int i=0,j=0;
        int index=0;
        while(j<n){
            // add negative number to deque
            if(nums[j]<0){
                freq[-nums[j]]++;
            }
            // window size not reached
             if(j-i+1<k){
               j++;
             }
             // window size reached
               else{
                    int count = 0;
                int beauty = 0;

                // find x-th smallest negative
                for (int val = 50; val >= 1; val--) {
                    count += freq[val];
                    if (count >= x) {
                        beauty = -val;
                        break;
                    }
                }

                result[index++] = beauty;

                // remove outgoing element
                if (nums[i] < 0) {
                    freq[-nums[i]]--;
                }

                i++;
                j++;
            }
        }
        return result;
    }
    }
