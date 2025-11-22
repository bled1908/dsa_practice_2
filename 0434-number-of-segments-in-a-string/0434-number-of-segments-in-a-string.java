class Solution {
    public int countSegments(String s) {
        s=s.trim().replaceAll("\\s+"," ");
        if(s.length()==0)
        {
            return 0;
        }
        int count = 1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                count++;
            }
        }
        return count;
    }
}