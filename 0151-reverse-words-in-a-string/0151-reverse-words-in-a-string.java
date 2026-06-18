class Solution {
    public String reverseWords(String s) {
        Stack<String> st=new Stack<>();
        int n=s.length();
        String str[]=s.trim().split("\s+");

        for(String w:str){
            st.push(w);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            String word=st.pop();
            sb.append(word);
            if(!st.isEmpty()){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}