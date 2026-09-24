class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans=new ArrayList<>();
        String word=words[0];
        int[] freq=new int[26];
        // Count characters of first word
        for(char ch:word.toCharArray()){
           freq[ch-'a']++;
        }
        // Compare with every other word
        for(int i=1;i<words.length;i++){
            int[] current=new int[26];
            for(char ch:words[i].toCharArray()){
                current[ch-'a']++;
            }
              // Keep minimum frequency
            for(int j=0;j<26;j++){
                freq[j]=Math.min(freq[j],current[j]);
            }
        }
         // Build answer
        for(int k=0;k<26;k++){
            while(freq[k]>0){
                ans.add(String.valueOf((char)(k+'a')));
                freq[k]--;
            }
        }
        return ans;
    }
}