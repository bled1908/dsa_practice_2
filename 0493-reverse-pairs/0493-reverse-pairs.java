class Solution {
   int count=0;
    public void merge(int arr[],int low,int mid,int high){
        List<Integer>list=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid &&right<=high){
            if(arr[left]<arr[right]){
                list.add(arr[left]);
                left++;
            }
            else{
                list.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            list.add(arr[left]);
            left++;
        }
        while(right<=high){
            list.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=list.get(i-low);
        }
        
    }
    public void countreverse(int arr[],int low,int mid,int high){
        int right=mid+1;
        for(int i=low;i<=mid;i++){ //checking for each left      //keyligic agar left k 3 ele k pair bnchuka h right 2 ele k sath and both half are sorted so next left k pair v utne rightele k sath bnega
            while(right<=high &&arr[i]>2L*arr[right]){ //2l prevents integer oveflow
                //Since one operand is long, The other (arr[right]) is automatically promoted to long too
                right++;
            }
            count+=right-(mid+1);    // Add the number of valid reverse pairs for this 'i'
        }
    }
    public void mergesort(int arr[],int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;  //just mergesort
        mergesort(arr,low,mid);
        mergesort(arr,mid+1,high);
        countreverse(arr,low,mid,high);
        merge(arr,low,mid,high);
    }
    public int reversePairs(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return count;
    }
}  //divide logn *merge (n +n)