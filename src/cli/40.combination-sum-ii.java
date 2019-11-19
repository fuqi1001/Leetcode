class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
	Arrays.sort(candidates);
	generate(res, new ArrayList<>(), candidates, target, 0);
	return res;
    }
    private void generate(List<List<Integer>> res, List<Integer> curr, int[] nums, int target, int move) {
	if (target < 0) return;
	else if (target == 0) {
	    res.add(new ArrayList<>(curr));
	} else {
	    for(int i = move; i < nums.length; i++) {
		if (i > move) {
		    if (nums[i] == nums[i-1]) continue;
		}
		curr.add(nums[i]);
		generate(res, curr, nums, target - nums[i], i + 1);
		curr.remove(curr.size() - 1);
	    }
	}
    }
}
