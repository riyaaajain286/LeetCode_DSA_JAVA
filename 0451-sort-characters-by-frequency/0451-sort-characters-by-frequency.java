class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        // /Count frequency
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // Max heap based on frequency
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        //Add all unique characters
        pq.addAll(map.keySet());
        StringBuilder sb=new StringBuilder();
        //Build answer
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int freq=map.get(ch);
            for(int i=0;i<freq;i++){
              sb.append(ch);
            }
        }
        return sb.toString();
    }
}