class Solution {
    public int maxDistance(int[]arr, int k) {
     Arrays.sort(arr);
        int n = arr.length;
        int low = 1;
        int high = arr[n - 1] - arr[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(arr,k,mid)){
                ans = mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int arr[], int k,int mid){
        int pos=arr[0];
        int c=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-pos>=mid){
                pos=arr[i];
                c++ ;
            }
            if(c==k){
                return true;
            }
        }
        return false;
    }
}