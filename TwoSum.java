/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution.
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
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