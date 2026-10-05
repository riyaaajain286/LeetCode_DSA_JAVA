class Solution {
    public class Pair{
        char ch;
        int count;
        public Pair(char ch,int count){
             this.ch=ch;
             this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();
        for(char ch:s.toCharArray()){
              // New character
            if(st.isEmpty() ||st.peek().ch!=ch)
              st.push(new Pair(ch,1));
              
               // Same character as the top
            else
              st.peek().count++;
            // If count becomes k, remove it
            if(st.peek().count==k)
              st.pop();
        }
         // Build answer
        StringBuilder sb=new StringBuilder();
        for(Pair p:st){
            char ch=(char) p.ch;
            int count=p.count;
            for(int i=0;i<count;i++)
               sb.append(ch);
        }
        return sb.toString();
    }
}