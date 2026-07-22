class Solution {
    public String minWindow(String s, String t) {
        int l=0;
        int r=0;
        HashMap<Character,Integer>h=new HashMap<>();
        HashMap<Character,Integer>h1=new HashMap<>();
        for(int j=0;j<t.length();j++){
            h1.put(t.charAt(j),h1.getOrDefault(t.charAt(j),0)+1);
            
        }
        int ans=Integer.MAX_VALUE;
        String k="";
        for(r=0;r<s.length();r++){
            h.put(s.charAt(r),h.getOrDefault(s.charAt(r),0)+1);
            while(is(h,h1)){
                if(r-l+1<ans){
                    ans=r-l+1;
                k=s.substring(l,r+1);
                
                }
                h.put(s.charAt(l),h.get(s.charAt(l))-1);
                l++;
            }
        }
        return k;
    }
    public static boolean is(HashMap<Character,Integer>h,HashMap<Character,Integer>h1){
        for(char ch:h1.keySet()){
            if(h.getOrDefault(ch,0)<h1.get(ch))
             return false;
        }
        return true;
    }
}