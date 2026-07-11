class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap();
        for(String s:strs){
            char[] st=s.toCharArray();
             Arrays.sort(st);
            String c=new String(st);
            if(!map.containsKey(c)){
                map.put(c,new ArrayList<>());
                 map.get(c).add(s);
            }
            else{
                map.get(c).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}