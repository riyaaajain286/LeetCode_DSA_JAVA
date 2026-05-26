class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            // Arrays.sort(ch);
            int[] freq=new int[26];
            //freq reduces sorting complexity now n*k instead if n*klog k
            for(char c:ch){
                freq[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i:freq){
              sb.append(i).append("#");
            }
            String key=sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}