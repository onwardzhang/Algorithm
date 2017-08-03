public class Solution {
    // a good dfs usage!
    //[IMPORTANT]
    //[NEEDREVIEW]
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        // [FAILED]
        //[IMPORTANT]
        // cannot use Arrays. sort(T[] a, Comparator<? super T> c) to sort a primitive array, only works on non-primitive array types.
        // Arrays.sort(nums, Collections.reverseOrder());
        // best way is to sort ascending, and then reverse it manually
        descendingSort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 4 != 0) {
            return false;
        }
        return dfs(nums, 0, sum / 4, new int[4]);
    }
    
    private boolean dfs(int[] nums, int index, int target, int[] sums) {
        if (index == nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[index] > target) {
                continue;
            }
            sums[i] += nums[index];
            if (dfs(nums, index + 1, target, sums)) {
                return true;
            }
            sums[i] -= nums[index];
        }
        return false;
    }
    
    // [IMPORTANT]
    private void descendingSort(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}