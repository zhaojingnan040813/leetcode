二分查找的边界通常指数组的起始索引和结束索引，需要根据具体实现方式确定：

左闭右闭区间：left = 0, right = nums.length - 1
（包含左右端点，循环条件为 left <= right）
左闭右开区间：left = 0, right = nums.length
（包含左端点，不包含右端点，循环条件为 left < right） 这样右边的值是取不到的

计算中间点：mid = left + (right - left) / 2（防溢出）