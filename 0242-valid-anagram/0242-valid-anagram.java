class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m) return false;
        int[] freq=new int[26];
        for(char a:s.toCharArray()){
            freq[a-'a']++;
        }
        for(char b:t.toCharArray()){
            freq[b-'a']--;
        }
        for(int i:freq){
            if(i!=0) 
             return false;
        }
        return true;
    }
}