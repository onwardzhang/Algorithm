public class Solution {
//     // dfs, no pruning [FAILED] TLE
//     private static final int[] sign = {1, -1};
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int[] result = new int[2];
//         dfs(nums, S, 0, result);
//         return result[0];
//     }
    
//     private void dfs(int[] nums, int S, int start, int[] result) {
//         if (start == nums.length) {
//             if (result[1] == S) {
//                 result[0]++;
//             }
//             return;
//         }
//         for (int i = 0; i < sign.length; i++) {
//             result[1] += sign[i] * nums[start];
//             dfs(nums, S, start + 1, result);
//             result[1] -= sign[i] * nums[start];
//         }
//     }
    
    // dfs, add some pruning, reference jiuzhang solution 2
    private static final int[] sign = {1, -1};
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] postSum = new int[nums.length];
        postSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postSum[i] = postSum[i + 1] + nums[i];
        }
        int[] result = new int[2]; // result[0]: count, result[1]: currentSum
        dfs(nums, S, 0, result, postSum);
        return result[0];
    }
    
    private void dfs(int[] nums, int S, int start, int[] result, int[] postSum) {
        if (start == nums.length) {
            if (result[1] == S) {
                result[0]++;
            }
            return;
        }
        
        // pruning
        if (Math.abs(S - result[1]) > postSum[start]) {
            return;
        }
        
        for (int i = 0; i < sign.length; i++) {
            result[1] += sign[i] * nums[start];
            dfs(nums, S, start + 1, result, postSum);
            result[1] -= sign[i] * nums[start];
        }
    }

    // TODO DP solution
}