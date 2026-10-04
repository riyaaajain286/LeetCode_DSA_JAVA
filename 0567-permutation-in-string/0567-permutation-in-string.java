class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        if(s1.length()>s2.length()) return false;
        for(char ch:s1.toCharArray()){
            freq[ch-'a']++;
        }
        int count=s1.length();
        int left=0,right=0;
        while(right<s2.length()){
            char ch=s2.charAt(right);
            if(freq[ch-'a']>0)
               count--;
            freq[ch-'a']--;
            right++;
            if(count==0)
              return true;
            if(right-left==s1.length()){
                char l=s2.charAt(left);
                if(freq[l-'a']>=0)
                   count++;
                freq[l-'a']++;
                left++;
            }
        }
        return false;
    }
}