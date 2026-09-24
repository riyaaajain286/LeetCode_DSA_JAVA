class Solution {
    public int firstUniqChar(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int ans=-1;
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1){
                ans=i;
                // return i;
                break;
            }
        }
        // return -1;
        return ans;
    }
}