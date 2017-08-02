public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return results;
        }
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> results) {
        if (tmp.size() > 1) {
            results.add(new ArrayList<>(tmp));
        }
        Set<Integer> used = new HashSet<>(); // key point! create a set at every level
        for (int i = start; i < nums.length; i++) {
            if ( used.contains(nums[i]) || (tmp.size() > 0 && nums[i] < tmp.get(tmp.size() - 1)) ) {
                continue;
            }
            tmp.add(nums[i]);
            used.add(nums[i]);
            dfs(nums, i + 1, tmp, results);
            tmp.remove(tmp.size() - 1);
        }
    }
}