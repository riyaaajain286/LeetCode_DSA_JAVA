class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int count=m;
        int l=0,r=0;
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int start=0,minLen=Integer.MAX_VALUE;
        while(r<n){
            char right=s.charAt(r);
            if(freq[right]>0)
              count--;
            freq[right]--;
            while(count==0){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    start=l;
                }
            
                char left=s.charAt(l);
                freq[left]++;
                if(freq[left]>0){
                    count++;
                }
                l++;
            }
            r++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}