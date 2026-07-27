class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int longestStreak=1;int currStreak = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] == nums[i-1] +1){
                currStreak++ ;
            }
            else{
                longestStreak = Math.max(longestStreak, currStreak);
                currStreak = 1;
            }
        }
        return longestStreak = Math.max(longestStreak, currStreak);
    }
}