class Solution {
    public String toHex(int num) {
        char[] ch="0123456789abcdef".toCharArray();
        if(num==0){
            return "0";
        }
        long n=num;
        if(n<0){
            n+=(1L<<32);
        }
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int rem=(int)(n%16);
            n=n/16;
            sb.append(ch[rem]);
        }
        return sb.reverse().toString();
    }
}