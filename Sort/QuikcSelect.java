class Solution {
    int[] nums;
    int qselect(int l, int r, int k) {
        // 終止條件
        if (l == r) return nums[k];
        // x相當於pivot，l-1,r+1才會包含l,r
        // 此模板先do ++再判斷，不會越界
        int x = nums[l], i = l - 1, j = r + 1;
        // int x = nums[l+r>>1]
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        if (k <= j) return qselect(l, j, k);
        else return qselect(j + 1, r, k);
    }
    void swap(int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
    public int findKthLargest(int[] _nums, int k) {
        nums = _nums;
        int n = nums.length;
        //quick sort完是由小到大，[1,2,3,4,5] 第一大是5
        //第K大=第n-k小
        return qselect(0, n - 1, n - k);
    }
}


//y總
//https://www.acwing.com/blog/content/277/

//先比對lfool-notes跟y總板子的差別

//先比對y總版本跟宮水的差異
//https://lfool.github.io/LFool-Notes/algorithm/%E8%AF%A6%E8%A7%A3%E5%BF%AB%E6%8E%92%E5%8F%8A%E5%85%B6%E5%BA%94%E7%94%A8.html
//再比較lfool-notes的差異quicksort/select

//差別好像就只在搜左右子樹而已

//進階試試排序鏈表

//chatgpt
//要将快速排序（Quick Sort）修改为快速选择（Quick Select），需要进行一些适应性调整，因为这两个算法的目标和操作有所不同。下面是将快速排序修改为快速选择的关键变化：
//排序变为查找： 快速选择的目标是查找数组中第k小的元素，而不是对整个数组进行排序。
//  因此，在修改时，不需要递归地对两个分区进行排序，而只需专注于包含第k小元素的那个分区。

//停止条件： 在快速选择中，不需要对每个分区都继续递归排序，只需关注包含第k小元素的那个分区。
//  因此，需要适当修改递归停止的条件。