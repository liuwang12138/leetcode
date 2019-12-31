package twenty.jan.one.question1;

import java.util.Arrays;

/**
 * @author Godric
 * @date 2019/12/31 16:07
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int []intArr = {0, 0};
        for (int i=0; i<length-1; i++) {
            for (int j=i+1; j<length; j++) {
                if (nums[i] + nums[j] == target) {
                    intArr[0] = i;
                    intArr[1] = j;
                    return intArr;
                }
            }
        }
        return intArr;
    }

    public static void main(String[] args) {

        int []nums = {2, 7, 11, 15};
        int target = 9;

        Solution s = new Solution();
        int[] intArr = s.twoSum(nums, target);
        Arrays.stream(intArr).forEach(System.out::println);

    }

}
