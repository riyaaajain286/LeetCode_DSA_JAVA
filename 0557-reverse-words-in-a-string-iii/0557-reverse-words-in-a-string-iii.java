class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split("\s");
       
        StringBuilder sb=new StringBuilder();
        for(String ss:arr){
            // for(int i=ss.length()-1;i>=0;i--){
            //     char ch=ss.charAt(i);
            //     sb.append(ch);
                
            // }
            StringBuilder word=new StringBuilder(ss).reverse();
            sb.append(word);
            sb.append(" ");
        }
        String ans=sb.toString();
       
        return ans.trim();
    }
}