class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] s=str.toCharArray();
            Arrays.sort(s);
            String st=new String(s);
            if(!map.containsKey(st)){
                map.put(st,new ArrayList<>());
            }
            
            map.get(st).add(str);
        }
        return new ArrayList<>(map.values());
    }
}