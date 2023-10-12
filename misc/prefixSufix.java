//Leetcode 238
//该类型的题目最大的特点：
//  判断一个数左右两边是否满足要求
//  求一个数左右两边的乘积


//「从左到右」：left[i]表示[0...i-1]的乘积
//「从右到左」：right[i]表示[i+1...n-1]的乘积
public int[] constructArr(int[] a) {
    int n = a.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int product = 1;
    for (int i = 0; i < n; i++) {
        left[i] = product;
        product *= a[i];
    }
    product = 1;
    for (int i = n - 1; i >= 0; i--) {
        right[i] = product;
        product *= a[i];
    }
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
        ans[i] = left[i] * right[i];
    }
    return ans;
}