package com.lyc.study.leetcode;

import java.util.*;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/6/11
 * @time: 19:29
 * @desc: LeetCode Easy
 */
public class Easy {

    public static void main(String[] args) {

        int[] ints = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(ints));
    }



    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum() {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int length = nums.length;
        for(int i = 0; i < length-1; i++){
            int a = target - nums[i];
            for(int j = i+1; j <length; j++){
                if(nums[j] == a){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res; //长度小于3 直接返回
        Arrays.sort(nums); //排序 左<右
        for (int k = 0; k < nums.length; ++k) {
            if (nums[k] > 0) break;// 左数大于0 直接返回
            if (k > 0 && nums[k] == nums[k - 1]) continue;//左数等于右侧数 跳过本次循环 (取相同数最右侧的数字 2 2 2 取第三个2当做左数)
            int target = 0 - nums[k]; // 得到剩余两个数之和
            int i = k + 1, j = nums.length - 1; //得到中间数和右数索引
            while (i < j) {
                if (nums[i] + nums[j] == target) { // 得到满足条件的中间数和右数
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));//添加进结果
                    while (i < j && nums[i] == nums[i + 1]) ++i;//中间数去重
                    while (i < j && nums[j] == nums[j - 1]) --j;//右数去重
                    ++i; --j;//继续查找下一组中间数和右数
                } else if (nums[i] + nums[j] < target) ++i; //中间数和右数相加结果小于目标值 中间数索引+1
                else --j; //右数索引-1
            }
        }
        return res;
    }


    /**
     * 大佬答案
     */

    public static List<List<Integer>> threeSum2(int nums[]){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || i > 0 && nums[i] != nums[i-1]){//nums[i] != nums[i-1] 去重
                int l = i+1, r = nums.length-1;
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;//去重
                        l++;
                        r--;
                    }else if (sum > 0){
                        while(l < r && nums[r] == nums[r-1]) r--;//去重
                        r--;
                    }
                    else {
                        while(l < r && nums[l] == nums[l+1]) l++;//去重
                        l++;
                    }
                }
            }
        }
        return res;
    }
}