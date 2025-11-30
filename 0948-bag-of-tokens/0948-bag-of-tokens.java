class Solution {
    public int bagOfTokensScore(int[] arr, int power) {
        Arrays.sort(arr);
        int score = 0;
        int i = 0;
        int j = arr.length-1;
        int max = 0;
        while(i<=j)
        {
            max = Math.max(max,score);
           // System.out.println(power+" "+arr[i]+" "+arr[j]);
          if(arr[i]<=power)
          {
              power-=arr[i];
              i++;
              score++;
          }
          else if(score>0)
          {
              power+=arr[j];
              j--;
              score--;
          }
          else{
              i++;
              j--;
          }

        }
max = Math.max(max,score);
        return max;
    }
}