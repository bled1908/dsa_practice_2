class Solution {
    public int romanToInt(String s) {
        
        //1.You store values like this in Map
        Map<Character,Integer> hm=new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

    //2.You can do this in one line like this
    //Map<Character, Integer> val = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);

    int total=0;
    for(int i=0;i<s.length();i++)
    {
        int curr=hm.get(s.charAt(i));               // value of current symbol
        // if a bigger symbol comes next, current is a subtraction (e.g. I before V = IV = 4)
        if( i+1 < s.length() && curr < hm.get(s.charAt(i+1)))
        total-=curr;                                // smaller-before-bigger -> subtract
        else
        total+=curr;                                // normal case -> add
    }
    
    return total;
    }
}