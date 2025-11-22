class Solution {
    public int[] findRightInterval(int[][] inter) {
        // so now we have to return here which would be the right interval for it 
        // so now first of all we will be using the 2d array to store all of the points so we can do the binary
        // search for index greater than equal to target 
        int n = inter.length;
        int[][] arr = new int[n][2]; // so the first value will be the starting points of all index 
        // and second point will be their real index then we will sort this array based on the first index 
        for(int i = 0; i < n; i++){
            arr[i][0] = inter[i][0];
            arr[i][1] = i;
        }
        // so now sorting this array 
        Arrays.sort(arr , (a , b)->a[0]-b[0]);

        // so now we will be making the binary search function which will reaturn the element >= target 

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = mBinary(arr , inter[i][1]);
        }

        return ans;
    }
    int mBinary(int[][] arr , int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid][0] == target){
                return arr[mid][1];
            }else if(target < arr[mid][0]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        // System.out.println(target);
        // System.out.println(start);

        return start == arr.length? -1 : arr[start][1];
    }
}