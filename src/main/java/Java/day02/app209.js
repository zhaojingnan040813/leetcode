/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * @param target
 * @param nums
 * @returns {number}
 */
var minSubArrayLen = function (target, nums) {
    let left = 0
    var right = 0
    var minLength = Infinity //滑动窗口的最小长度
    // var max=0 //滑动窗口的最大值
    var sum = 0; //滑动窗口元素和

    for (right; right < nums.length; right++) {
        sum += nums[right]

        while (sum >= target) {//有没有这个等于,我觉得应该没有(其实有，因为num[left] 的值可能为0，它会影响到currentLength)
            var currentLength = right - left + 1 //当前的长度
            minLength = Math.min(minLength, currentLength)
            sum = sum - nums[left];
            left++;

        }
    }
    return minLength === Infinity ? 0 : minLength


};

// 暴力解法
// var minSubArrayLen = function(target, nums) {
//
//     let minLength=Infinity
//
//     for (let i=0;i<nums.length;i++){
//         let sum=0
//
//         for (let j=i;j<nums.length;j++){
//             sum+=nums[j]  // 这里就可以看出是连续子数组
//             if (sum>=target){
//                 minLength=Math.min(j-i+1,minLength)
//                 break;//注意这个break跳出的是if还是for
//             }
//
//         }
//
//     }
//     return minLength === Infinity ? 0 : minLength;
//
// };