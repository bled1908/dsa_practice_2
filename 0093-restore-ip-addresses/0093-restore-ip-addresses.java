class Solution {
    public void helper(String str, int start,int pCount ,String part ,List<String> result){
        if(start == str.length() && pCount == 4){
            result.add(part);
            return;
        }
        if(pCount == 4 || start == str.length()) return;

        for(int i = start + 1; i<= (start + 3) && i <= str.length();i++){
            String subStr =str.substring(start,i);
            if(subStr.charAt(0) == '0' && subStr.length() > 1 ) break;

            if(Integer.parseInt(subStr) > 255) break;
            String newPart = (part == "")? subStr : (part + "." + subStr);
            helper(str,i,pCount + 1, newPart,result);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if(n > 12 || n < 4) return result;
        helper(s,0,0,"",result);
        return result;
    }
}