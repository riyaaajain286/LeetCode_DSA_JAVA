class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.equals(magazine)) 
           return true;
           int n=ransomNote.length();
           int m=magazine.length();
           if(n>m) return false;
        int[] freq=new int[26];
        for(int i=0;i<m;i++){
            char ch=magazine.charAt(i);
            freq[ch-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            freq[c-'a']--;
            if(freq[c-'a']<0) return false;
        }
        return true;
    }
}