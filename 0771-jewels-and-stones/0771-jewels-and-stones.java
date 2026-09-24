class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=stones.length();
        for(char ch:stones.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=0;
        for(char c:jewels.toCharArray()){
            if(map.containsKey(c)){
                count+=map.get(c);
                map.put(c,0);
            }
        }
        return count;
    }
}