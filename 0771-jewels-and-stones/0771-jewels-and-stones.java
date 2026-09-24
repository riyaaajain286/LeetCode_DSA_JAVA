class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(char c:jewels.toCharArray()){
           for(char ch:stones.toCharArray()){
               if(c==ch)
                  count++;
            }
        }
        return count;
    }
}