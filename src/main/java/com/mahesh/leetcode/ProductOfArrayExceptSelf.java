package com.mahesh.leetcode;

//LeetCode - 238
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

    }
/**
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
    public static int[] productExceptSelf(int [] nums){
        int[] res = new int[nums.length];
        res[0] = 1; // Left product for first element is 1
        for (int i = 1; i < nums.length ; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int rightProduct = 1; // right product of last element is 1
        for (int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return res;
    }
}
