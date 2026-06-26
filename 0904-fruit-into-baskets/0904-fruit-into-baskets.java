class Solution {
    //largest window(subarray) having 2 different or unique type of fruits
    public int totalFruit(int[] fruits) {
        int l=0,r=0,maxlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=fruits.length;
        while(r<n){
             // Add current fruit
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2){
                // Shrink window if more than 2 fruit types
               map.put(fruits[l],map.get(fruits[l])-1);
               if(map.get(fruits[l])==0)
                 map.remove(fruits[l]);
               l++;
            }
             // Update answer
             if(map.size()<=2){
                int len=r-l+1;
                maxlen=Math.max(len,maxlen);
            }
            r++;
        }
        return maxlen;
    }
}