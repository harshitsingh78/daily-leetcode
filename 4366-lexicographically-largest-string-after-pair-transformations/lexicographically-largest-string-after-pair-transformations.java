class Solution {
    public String[] largestString(int[] nums) {
        String[] result = new String[nums.length];
        int zValue = 1 << 25;
        for(int i=0;i<nums.length;i++){
            int x= nums[i];
            StringBuilder sb = new StringBuilder();
            int countZ = x/zValue;
            for(int j=0;j<countZ;j++){
                sb.append('z');
            }
            int remainder = x % zValue;
            for(int bit=24;bit>=0;bit--){
                if(((remainder >> bit) &1 ) == 1){
                    sb.append((char)('a' + bit));
                }
            }
            result[i] = sb.toString();
        }
        return result;
    }
}