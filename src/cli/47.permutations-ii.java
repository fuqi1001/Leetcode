class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

    }

    public void generate(int[] nums, List<List<Integer>> res, List<Integer> cur, List<Integer> curIndex) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (curIndex.contains(i))
                    continue;
                if (i > 0 && !curIndex.contains(i - 1) && nums[i - 1] == nums[i]) {
                    continue;
                }
                curIndex.add(i);
                cur.add(nums[i]);
                generate(nums, res, cur, curIndex);
                curIndex.remove(curIndex.size() - 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
