class Solution {
    public int findNthDigit(int n) {
        long digits=1;
        long count=9;
        long start=1;
        // Find the digit-length group
        while(n>digits*count){
            n-=digits*count;
            digits++;
            count*=10;
            start*=10;
        }
        // Find which number contains the nth digit
        long number=start+(n-1)/digits;
        // Find which digit inside that number
        long index=(int)((n-1)%digits);
        String str=String.valueOf(number);
        return str.charAt((int)index)-'0';
    }
}