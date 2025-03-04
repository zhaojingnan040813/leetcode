// JavaScript的数组是动态的，可以随时添加或删除元素

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function (nums) {
    let n = nums.length
    // let res = new Array(n) //不定义长度的话就直接一个空数组
    let res = new Array(n).fill(0) //不定义长度的话就直接一个空数组
    let left = 0, right = n - 1
    let index = n - 1
    while (left <= right) {

        if ( Math.pow(nums[left], 2) < Math.pow(nums[right],2)){
            res[index--]=Math.pow(nums[right],2);
            right--;
        }else{
            res[index--]=Math.pow(nums[left],2)
            left++;
        }
    }
    return res
};