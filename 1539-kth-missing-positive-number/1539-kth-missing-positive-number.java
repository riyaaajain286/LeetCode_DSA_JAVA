class Solution {
    public int findKthPositive(int[] arr, int k) {
        // This means if the array did not exist,the positive no should simply be that no 
        // But every array element <= k is a number that is present, so it pushes the k-th missing number one position forward.
        for(int n:arr){
            if(n<=k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
}