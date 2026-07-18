class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp = target-nums[i];
            if(res.containsKey(comp)){
                return new int[] {res.get(comp),i};

            }
            res.put(nums[i],i);
        }
        return new int[] {-1,-1};
        
    }
}