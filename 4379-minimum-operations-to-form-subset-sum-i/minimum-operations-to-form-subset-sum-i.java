class Solution {
    public int minOperations(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

        for (int num : nums) {
            Map<Integer, Integer> transformations = cache.computeIfAbsent(num, n -> getTransformations(n, sum));
            int[] nextDp = Arrays.copyOf(dp, dp.length);
            
            for (Map.Entry<Integer, Integer> entry : transformations.entrySet()) {
                int v = entry.getKey();
                int cost = entry.getValue();
                
                for (int j = sum; j >= v; j--) {
                    if (dp[j - v] != INF) {
                        nextDp[j] = Math.min(nextDp[j], dp[j - v] + cost);
                    }
                }
            }
            dp = nextDp;
        }

        return dp[sum] >= INF ? -1 : dp[sum];
    }

    private Map<Integer, Integer> getTransformations(int x, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int divOps = 0;
        long currentDiv = x;
        while (currentDiv >= 0) {
            if (currentDiv <= targetSum) {
                map.put((int) currentDiv, divOps);
            }
            if (currentDiv == 0) break;
            currentDiv /= 2;
            divOps++;
        }
        
        if (x > 0) {
            int multOps = 1;
            long currentMult = (long) x * 2;
            
            while (currentMult <= targetSum * 2) {
                divOps = 0;
                currentDiv = currentMult;
                while (currentDiv >= 0) {
                    int totalOps = multOps + divOps;
                    if (currentDiv <= targetSum) {
                        map.put((int) currentDiv, Math.min(map.getOrDefault((int) currentDiv, Integer.MAX_VALUE), totalOps));
                    }
                    if (currentDiv == 0) break;
                    currentDiv /= 2;
                    divOps++;
                }
                currentMult *= 2;
                multOps++;
            }
        }
        
        return map;
    }
}