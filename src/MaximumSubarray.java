public class MaximumSubarray {
    public static void main(String[] args) {
        int[] table = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] table2 = new int[] {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(table));
        System.out.println(maxSubArray(table2));
    }
    public static int maxSubArray(int[] nums) {
    int currentSum = nums[0];
    int maxSum = currentSum;
    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], nums[i] + currentSum);
        if (maxSum < currentSum) {
            maxSum = currentSum;
        }
    }
        return maxSum;
    }
}
//    Maximum subarray (watch for Kadane's algorithm for the fastest solution)