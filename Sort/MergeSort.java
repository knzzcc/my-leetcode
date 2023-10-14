public class MergeSort {

    private int[] temp;

    public void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo == hi) return;
        //int mid = (lo + hi + 1) >> 1;
        int mid = lo - (lo - hi) / 2;
        //後序
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    // [lo..mid] 和 [mid+1..hi]
    private void merge(int[] nums, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) temp[i] = nums[i];

        int cnt = lo;
        int i = lo, j = mid + 1;

        while (i <= mid || j <= hi) { // 只要i, j指針有一個不越界就繼續
            if (i > mid) nums[cnt++] = temp[j++];
            else if (j > hi) nums[cnt++] = temp[i++];
            else if (temp[i] <= temp[j]) nums[cnt++] = temp[i++];
            else nums[cnt++] = temp[j++];
        }
    }
    // 先複製nums->tmp, cnt=lo 指著nums, i=lo,j=mid+1 指著tmp
    // 在指針不越界情況下i->mid, j->hi
    // 如果i搬空(i>mid), j指針移動 tmp搬到nums;
    // 如果j...
    // 如果i對應值<=j，搬i
    
    // in short i越界搬j,i小搬i | 因為merge後要nums[i]<nums[j]

}

//  逆序對
//  int[] a = {5, 3, 2}
//  滿足 i < j, a[i] > a[j]