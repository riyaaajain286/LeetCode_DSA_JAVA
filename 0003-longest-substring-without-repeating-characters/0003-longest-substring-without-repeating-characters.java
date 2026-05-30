class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length()==1 && s.charAt(0)=='') return 0;
        int maxlen=0;
        int i=0;
        Set<Character> set=new HashSet<>();
        for(int j=0;j<s.length();j++){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxlen=Math.max(maxlen,j-i+1);
            
        }
        return maxlen;
    }
}