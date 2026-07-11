class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> set=new HashSet<>();
        int maxlen=0;
        int i=0,j=0;
        while(j<s.length()){
            while(set.contains(s.charAt(j))){//keep removing duplicates till all r removed
            set.remove(s.charAt(i));
            i++;
            
          }
          
            set.add(s.charAt(j));
            maxlen=Math.max(maxlen,j-i+1);//when all unique nd different find length
            j++;
          }
        
        return maxlen;
    }
}