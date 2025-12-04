class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list =new ArrayList();
        for(String str:queries){
            list.add(bool(str,pattern));
        }
        return list;
    }
	//Checking the occurance of char in the string str with the pattern and incrementing count
	//if count is equal to the pattern return true
	
    Boolean bool(String str,String pattern){
        int i=0;
        for(char c: str.toCharArray()){
            if(i<pattern.length() && c==pattern.charAt(i)){
                i++;
            }    
            //checking the rest of string if there is a UpperCase character
            else if(c<'a'){
                return false;
            }
        }
        return i==pattern.length();
        
    }
}