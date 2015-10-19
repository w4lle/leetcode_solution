public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        final HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(target - nums[i])) {
                int index = h.get(target-nums[i])+1;
                res[0] = Math.min(i+1, index);
                res[1] = Math.max(i+1, index);
            }
            h.put(nums[i], i);
        }

        return res;
    }
}