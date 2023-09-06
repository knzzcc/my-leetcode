public class QuickSort {

    private final Random random = new Random();

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return; // 終止條件

        // 前序 dosomething
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {

        // 方法二：随机取
        int p = random.nextInt(hi - lo + 1) + lo; // [lo, hi]
        swap(nums, lo, p);

        int pivot = nums[lo];
        int i = lo + 1, j = hi;

        while (i <= j) {
            // while 结束后，[lo, i) 均 <= pivot
            while (i < hi && nums[i] <= pivot) i++;
            // while 结束后，(j, hi] 均 > pivot
            while (j > lo && nums[j] > pivot) j--;
        
            // ------ 若为降序，只需更改此处两行代码即可 ------
            // while (i < hi && nums[i] >= pivot) i++
            // while (j > lo && nums[j] < pivot) j--;
            // ------------------- end -------------------
           
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

// 前序，先找到切割點p，切成[lo, p-1][p, hi]，sort左，sort右

// 切割點隨機取，但取完切割點後，index在p之前的"值"要比較小

// 具題實現，隨機取p跟頭lo交換，這時p在頭lo, i=lo+1, j=hi，指針相向走
// while結束後[lo, i)<=pivot (j, hi]>pivot
// p還在頭lo，要跟j交換位置


// MergeSort切 [lo..mid] [mid+1...hi]
// QuickSort切 [lo..p-1] [p] [p+1...hi]

// QuickSelect
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/1879861/by-ac_oier-x9h4/
// https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/1426913/by-feifeisha-fhi3/