class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0,twenty=0;
       for(int i=0; i<bills.length; i++)
       {
        if(bills[i]==5) {
            five++;
        }
        else if(bills[i]==10)  {
            ten++;
            if(five<1)  return false;
            else{
                five--;
            }
        }
        else{
            if(five>0 && ten>0)
            {
                five--;
                ten--;
            }
            else if(five>2)
            {
                five-=3;
            }
            else{
                return false;
            }
        }

       }
       return true;
    }
}