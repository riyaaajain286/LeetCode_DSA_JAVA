class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty() ||st.peek()[0]!=ch)
              st.push(new int[]{ch,1});
            else
              st.peek()[1]++;
            
            if(st.peek()[1]==k)
              st.pop();
        }
        StringBuilder sb=new StringBuilder();
        for(int[] p:st){
            char ch=(char) p[0];
            int count=p[1];
            for(int i=0;i<count;i++)
               sb.append(ch);
        }
        return sb.toString();
    }
}