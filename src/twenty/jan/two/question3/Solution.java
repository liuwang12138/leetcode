package twenty.jan.two.question3;

/**
 * @author liuwang
 * @date 2020/1/2 10:06
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int k = 0;
        StringBuilder str = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (str.toString().contains(String.valueOf(s.charAt(i)))) {
                str = new StringBuilder();
                if (k > max) {
                    max = k;
                }
                k = 0;

                i = s.substring(0, i).lastIndexOf(s.charAt(i));
            } else {
                str.append(s.charAt(i));
                k++;
            }
        }

        if (k > max) {
            max = k;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}
