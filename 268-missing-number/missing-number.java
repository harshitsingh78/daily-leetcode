class Solution {
    public int missingNumber(int[] nums) {
        // the solution is using the XOR 
       int all = 0;
       for(int i=0; i<=nums.length; i++){
        all= all ^ i;
       }

       for(int num :nums ){
        all = all ^ num;
       }

       return all;
    }
}