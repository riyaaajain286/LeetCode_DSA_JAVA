class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int l=0;
        int[] freq=new int[26];
        int maxsize=Integer.MIN_VALUE;
        for(int r=0;r<n;r++){
           freq[s.charAt(r)-'a']++;
           while(freq[s.charAt(r)-'a']>2){
            freq[s.charAt(l)-'a']--;
            l++;
            }
           int window=r-l+1;
           maxsize=Math.max(window,maxsize);
        }
        return maxsize;
    }
}