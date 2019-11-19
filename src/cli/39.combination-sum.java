class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	List<List<Integer>> res = new ArrayList<>();
	if (candidates.length == 0) return res;
	Arrays.sort(candidates);
	List<Integer> curr = new ArrayList<>();
	generateCombination(res, curr, candidates, target, 0);
	return res;
    }
    private void generateCombination(List<List<Integer>> res, List<Integer> curr, int[] nums, int target, int move) {
	if (target < 0) return;
	else if (target == 0) {
	    res.add(new ArrayList<>(curr));
	} else {
	    for(int i = move; i < nums.length; i++){
		curr.add(nums[i]);
	        generateCombination(res, curr, nums, target - nums[i], i);
	        curr.remove(curr.size() - 1);
	    }
	}
    }
}
