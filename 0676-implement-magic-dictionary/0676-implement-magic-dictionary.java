class MagicDictionary {
List<String> list= new ArrayList<>();
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for(String s: dictionary)
        {
            list.add(s);
        }
    }
    
    public boolean search(String searchWord) {
        for(String s: list)
        {
            if(searchWord.length()== s.length() && !searchWord.equals(s))
            {
                if(isOneAway(s, searchWord))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isOneAway(String s1, String s2)
    {
        char[] ch1= s1.toCharArray();
        char[] ch2= s2.toCharArray();
      
        // System.out.println(Arrays.toString(ch1));
        //   System.out.println(Arrays.toString(ch2));
        int count= 0;
        for(int i= 0; i< ch1.length; i++)
        {
            if(ch1[i]!= ch2[i])
            {
                count++;
            }
        }
        return (count== 1);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */