class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int fro1 = firstPart(num1);
        int sec1 = secondPart(num1);

        int fro2 = firstPart(num2);
        int sec2 = secondPart(num2);
        //System.out.println(fro1+" fro "+sec1+" sec1 "+fro2+" fro2 "+sec2);

        int front = (fro1*fro2) + (sec1*sec2)*(-1);
        int second = (sec1*fro2) + (fro1*sec2);
        StringBuilder ans = new StringBuilder();
        ans.append(front).append('+').append(second).append('i');
        return ans.toString();
    }
    public int firstPart(String num){
        int ind = 0;
        int op = 0;
        if(num.charAt(ind) == '-'){
            op = 1;
            ind++;
        }
        int val = 0;
        while(num.charAt(ind) != '+'){
            //System.out.println(num.charAt(ind)-'0'+" pop  ");
            val = (val*10) + (num.charAt(ind)-'0');
            ind++;
        }
        if(op == 1){
            val*=-1;
        }
        return val;
    }
    public int secondPart(String num){
        int ind = 0;
        while(num.charAt(ind) != '+'){
            ind++;
        }
        int op = 0;
        ind++;
        if(num.charAt(ind) == '-'){
            op = 1;
            ind++;
        }
        int val = 0;
        while(ind < num.length() && num.charAt(ind) != 'i'){
            val = (val*10) + (num.charAt(ind)-'0');
            ind++;
        }
        if(op == 1){
            val *= -1;
        }
        return val;
    }
}