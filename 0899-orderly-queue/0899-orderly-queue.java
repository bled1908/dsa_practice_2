class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        if( k > 1 ) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String str = new String( temp );
            return str;
        }

        String result = s;
        for( int i = 1; i < n; i++ ) {
            String str = s.substring(i, n) + s.substring(0, i);
            
            if(str.compareTo(result) < 0 ) {
                result = str;
            }
        }
        return result;
        
    }
}