class Solution {
    public void reverseString(char[] s) {
        int i=0,j=s.length-1;
        while(i<=j){
            char ch1=s[i];
            char ch2=s[j];
            s[i]=ch2;
            s[j]=ch1;
            i++;
            j--;

        }
        
    }
}