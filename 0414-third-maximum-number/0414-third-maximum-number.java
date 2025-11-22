class Solution {
    public int thirdMax(int[] nums) {
        long firstmax=Long.MIN_VALUE;   //consider long min
        long secmax=Long.MIN_VALUE;
        long thirdmax=nums[0];
       // if(nums.length==2){return Math.max(nums[0],nums[1]);} //if no thirdmin return max
       // if(nums.length==1){return nums[0];} //last wale m handle hogya dono edgecase
      for(int i=0;i<nums.length;i++){
        if(nums[i]>firstmax){ //if got ele greater than 1rd update sec and third as well 
            thirdmax=secmax;
            secmax=firstmax;
            firstmax=nums[i];
        }
        else if(nums[i]>secmax &&nums[i]<firstmax){ //if got ele big than sec update third ele
            thirdmax=secmax;
            secmax=nums[i];


        }
        else if(nums[i]>thirdmax && nums[i]<secmax){
            thirdmax=nums[i]; //if any new ele smaller than sec but bigger than third update third
        }

      } 
      if(thirdmax==Long.MIN_VALUE || secmax==Long.MIN_VALUE){return (int)firstmax;} //edge if no third  return firstmax
      return (int)thirdmax;
    }
}