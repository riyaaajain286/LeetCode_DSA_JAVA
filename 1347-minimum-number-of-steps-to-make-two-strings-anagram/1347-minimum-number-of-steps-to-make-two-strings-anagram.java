class Solution {
    public int minSteps(String s, String t) {
        int[] fs=new int[26];
        int[] ft=new int[26];
        for(char cs:s.toCharArray()){
            fs[cs-'a']++;
        }
        for(char ct:t.toCharArray()){
            ft[ct-'a']++;
        }
        int c=0;
        for(int i=0;i<26;i++){
            int j=fs[i];
            int k=ft[i];
            if(j>k)
              c+=j-k;
        }
        return c;

    }
}