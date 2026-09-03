class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int maxSplits =0;
        maxSplits = Math.max(maxSplits,countSplits(nums,-1));

        for(int i=0;i<n;i++){
            maxSplits = Math.max(maxSplits,countSplits(nums,i));
        }
        return maxSplits;
    }

    private int countSplits(int[] nums,int skipIdx){
        int n = nums.length;
        int m = (skipIdx == -1 ) ? n : n -1;
        if(m<2){
            return 0;
        }
        int[] arr = new int[m];
        int idx =0;
        for(int i=0;i<n;i++){
            if(i == skipIdx) continue;
            arr[idx++] = nums[i];
        }
        
        int[] pref = new int[m];
        pref[0] =arr[0];
        for(int i =1;i<m;i++){
            pref[i] = gcd(pref[i-1],arr[i]);
        }

        int[] suff = new int[m];
        suff[m-1] =arr[m-1];
        for(int i =m-2;i>=0;i--){
            suff[i] = gcd(suff[i+1],arr[i]);
        }
        
        int validCount =0;
        for(int i=0;i<m-1;i++){
            if(pref[i] == suff[i+1]){
                validCount++ ;
            }
        }
        return validCount;
    }

    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}