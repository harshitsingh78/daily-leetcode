class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }

        int maxProd = nums[0];
        for(int i=0;i<n;i++){
            int currProd = 1;
            for(int j=i;j<n;j++){
                currProd *= nums[j];
                maxProd = Math.max(maxProd,currProd);
            }
        }
        return maxProd;
    }
}