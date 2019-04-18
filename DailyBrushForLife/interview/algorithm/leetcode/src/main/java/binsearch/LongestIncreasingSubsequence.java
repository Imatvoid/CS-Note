package binsearch;

public class LongestIncreasingSubsequence {

    /**
     * 最长上升子序列 o nlogn
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // [10,9,2,5,3,7,101,18]
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[len]) {
                dp[++len] = nums[i];
            }
            else {
                int index = binarySearch(dp, len, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    /**
     * 二分查找 查找插入位置
     * @param dp
     * @param len
     * @param val
     * @return
     */
    private int binarySearch(int[] dp, int len, int val) {
        int start = 0;
        while(start <= len) {
            int mid = start + (len - start) / 2;
            if(dp[mid] == val) {
                return mid;
            }
            else if(dp[mid] < val) {
                start = mid + 1;
            }
            else {
                len = mid - 1;
            }
        }
        return start;
    }
}
