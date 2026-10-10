class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ct:t.toCharArray()){
            freq[ct-'a']--;
        }
        for(int i:freq){
            if(i!=0)  
               return false;
        }
        return true;
    }
}