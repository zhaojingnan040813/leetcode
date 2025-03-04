/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */

var removeElement = function(nums, val) {
    let slow=0;
    for (let fast=0;fast<nums.length;fast++){
        if(nums[fast]!==val){
            nums[slow]=nums[fast]
            slow++;

        }
    }
    return slow

};




// var removeElement = function (nums, val) {
//     var size=nums.length;
//     for (let i=0;i<size;i++ ){
//         if (nums[i]===val){
//             for (var j=i+1;j<size;j++){
//                 nums[j-1]=nums[j]
//             }
//             i--;//这里i--.外层for循环i++ 相当于i没有动
//             size--;
//         }
//     }
//     return size;
// };

