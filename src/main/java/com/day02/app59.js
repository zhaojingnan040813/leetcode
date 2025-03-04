/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 */

/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function (n) {

    const matrix = Array(n).fill().map(() => Array.fill(0)) //在JS当中好麻烦啊
    let num = 1
    let top = 0, bottom = n - 1
    let left = 0, right = n - 1
    while (num < n * n) {
        for (let i=left;i<=right;i++)
            matrix[top][i]=num++;
        top++;
        for (let i=top;i<=bottom;i++)
            matrix[i][right]=num++
        right--

        for (let i=right;i>=left;i--)
            matrix[bottom][right]=num++

        for (let i=bottom;i>=top;i--)
            matrix[i]



    }


};

