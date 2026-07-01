import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
       int ans = nums[0] + nums[1] + nums[2];
        if(nums.length<3){
            return 0;
        }
        
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

           int low=i+1;
            int high=nums.length-1;

            while(low<high){
                int sum= nums[i]+nums[low]+nums[high];
                if(Math.abs(ans-target) > Math.abs(sum-target)){
                    ans=sum;      
                }
                if(sum==target){
                    return target;
                }else if(sum<target){
                    low++;
                }else{
                    high--;
                }  
            }
        }
        return ans;
    }
}