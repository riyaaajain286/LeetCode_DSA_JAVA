class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        List<Integer> list=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),i);
        }
        int start=0,end=0;
        for(int right=0;right<n;right++){
             // Extend partition if this character occurs later
             end=Math.max(end,map.get(s.charAt(right)));
              // Partition is complete
              if(right==end){
                list.add(right-start+1);
                start=end+1;
              }
        }
        return list;
    }
}