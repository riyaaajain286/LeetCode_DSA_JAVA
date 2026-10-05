class Solution {
    public String removeDuplicates(String s, int k) {
        // stack[i][0] = character
        // stack[i][1] = count
        int[][] st=new int[s.length()][2];
        int top=-1;
        for(char ch:s.toCharArray()){
            // Same character as the top
            if(top>=0 && st[top][0]==ch){
               st[top][1]++;
                // If count becomes k, remove it
                if(st[top][1]==k)
                top--;
            }
              //new character
            else{
              top++;
              st[top][0]=ch;
              st[top][1]=1;
            }
        }
        //build answer
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=top;i++){
            char ch=(char) st[i][0];
            int count=st[i][1];
            while(count-->0)
             sb.append(ch);
        }
        return sb.toString();
    }
}