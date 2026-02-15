class Solution {
    //Memoization
    HashMap<String,Boolean> memo=new HashMap<>();
    public boolean canCross(int[] stones) {
        return helper(stones,0,0);
    }
    public boolean helper(int[] stones,int index,int lastjump){
        int n=stones.length;
        if(index==n-1) return true;
        String key=index+","+lastjump;
        if(memo.containsKey(key))
           return memo.get(key);
        for(int i=index+1;i<n;i++){
            int gap=stones[i]-stones[index];
            if(gap>=lastjump-1 && gap<=lastjump+1){
                if(helper(stones,i,gap)){
                    memo.put(key,true);
                    return true;
                }
            }
        }
        memo.put(key,false);
        return false;
    }
}